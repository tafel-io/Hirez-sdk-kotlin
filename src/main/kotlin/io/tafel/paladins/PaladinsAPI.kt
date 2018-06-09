package io.tafel.paladins

import io.tafel.paladins.model.SessionResponse
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PaladinsAPI {


    @GET("{callName}Json")
    fun pingAPI(@Path("callName") pathKey: String): Deferred<String>

    @GET("{callName}Json/{devId}/{signature}/{timestamp}")
    fun createSession(@Path("callName") pathKey: String,
                      @Path("devId") devId: Int,
                      @Path("signature") signature: String,
                      @Path("timestamp") timeStamp: String): Deferred<SessionResponse>
}