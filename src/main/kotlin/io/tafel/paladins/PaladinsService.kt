package io.tafel.paladins

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import kotlinx.coroutines.experimental.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class PaladinsService(private val devId: Int, private val authKey: String) {
    private val sessionManager: SessionManager = SessionManager()
    private val paladinsClient: PaladinsAPI = Retrofit.Builder()
            .baseUrl("http://api.paladins.com/paladinsapi.svc/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getOKHTTPClient())
            .build()
            .create(PaladinsAPI::class.java)

    private fun getOKHTTPClient() = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }).build()

    suspend fun ping() = paladinsClient.pingAPI().await()

    suspend fun createSession() = getTimeStampAndSignaturePair(CREATE_SESSION)
            .let { paladinsClient.createSession(devId, it.first, it.second) }.await()

    suspend fun getServerStatus() = validateSessionAndRunApi({
        paladinsClient.getServerStatus(devId, it.first, sessionManager.sessionId, it.second)
    }, GET_HIREZ_SERVER_STATUS)

    suspend fun getDataUsed() = validateSessionAndRunApi({
        paladinsClient.getDataUsed(devId, it.first, sessionManager.sessionId, it.second)
    }, GET_DATA_USED)

    suspend fun getFriends(player: String) = validateSessionAndRunApi({
        paladinsClient.getFriends(devId, it.first, sessionManager.sessionId, it.second, player)
    }, GET_FRIENDS)

    private suspend fun <T> validateSessionAndRunApi(block: (a: Pair<String, String>) -> Deferred<T>,
                                                     callName: String) =
            if (sessionManager.isSessionValid()) {
                getTimeStampAndSignaturePair(callName).let { block(it).await() }
            } else {
                updateSession()
                getTimeStampAndSignaturePair(callName).let { block(it).await() }
            }

    private suspend fun updateSession() {
        sessionManager.updateSession(createSession())
    }

    private fun getTimeStampAndSignaturePair(callName: String): Pair<String, String> {
        val timeStamp = SimpleDateFormat("yyyyMMddHHmmss").apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }.format(Date())

        return "$devId$callName$authKey$timeStamp".md5() to timeStamp
    }


    companion object {
        const val PING = "ping"
        const val CREATE_SESSION = "createsession"
        const val GET_HIREZ_SERVER_STATUS = "gethirezserverstatus"
        const val GET_DATA_USED = "getdataused"
        const val GET_FRIENDS = "getfriends"
    }
}