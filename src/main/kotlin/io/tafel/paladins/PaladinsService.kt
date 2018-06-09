package io.tafel.paladins

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PaladinsService(val devId: String, val authKey: String) {
    private val paladinsClient: PaladinsAPI = Retrofit.Builder()
            .baseUrl("http://api.paladins.com/paladinsapi.svc/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(OkHttpClient())
            .build()
            .create(PaladinsAPI::class.java)

    suspend fun ping() = paladinsClient.pingAPI().await()
}