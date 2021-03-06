package io.tafel.paladins

import io.tafel.paladins.PaladinsService.Companion.CREATE_SESSION
import io.tafel.paladins.PaladinsService.Companion.GET_CHAMPIONS
import io.tafel.paladins.PaladinsService.Companion.GET_DATA_USED
import io.tafel.paladins.PaladinsService.Companion.GET_FRIENDS
import io.tafel.paladins.PaladinsService.Companion.GET_HIREZ_SERVER_STATUS
import io.tafel.paladins.PaladinsService.Companion.GET_PLAYER
import io.tafel.paladins.PaladinsService.Companion.PING
import io.tafel.paladins.model.*
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface PaladinsAPI {

    @GET("${PING}Json")
    fun pingAPI(): Deferred<String>

    @GET("${CREATE_SESSION}Json/{devId}/{signature}/{timestamp}")
    fun createSession(@Path("devId") devId: Int,
                      @Path("signature") signature: String,
                      @Path("timestamp") timeStamp: String): Deferred<SessionResponse>

    @GET("${GET_HIREZ_SERVER_STATUS}Json/{devId}/{signature}/{session}/{timestamp}")
    fun getServerStatus(@Path("devId") devId: Int,
                        @Path("signature") signature: String,
                        @Path("session") session: String,
                        @Path("timestamp") timeStamp: String): Deferred<List<ServerStatusResponse>>

    @GET("${GET_DATA_USED}Json/{devId}/{signature}/{session}/{timestamp}")
    fun getDataUsed(@Path("devId") devId: Int,
                    @Path("signature") signature: String,
                    @Path("session") session: String,
                    @Path("timestamp") timeStamp: String): Deferred<List<DataUsageResponse>>

    @GET("${GET_FRIENDS}Json/{devId}/{signature}/{session}/{timestamp}/{player}")
    fun getFriends(@Path("devId") devId: Int,
                   @Path("signature") signature: String,
                   @Path("session") session: String,
                   @Path("timestamp") timeStamp: String,
                   @Path("player") player: String): Deferred<List<Friend>>

    @GET("${GET_PLAYER}Json/{devId}/{signature}/{session}/{timestamp}/{player}")
    fun getPlayer(@Path("devId") devId: Int,
                  @Path("signature") signature: String,
                  @Path("session") session: String,
                  @Path("timestamp") timeStamp: String,
                  @Path("player") player: String): Deferred<List<PlayerInfo>>

    @GET("${GET_CHAMPIONS}Json/{devId}/{signature}/{session}/{timestamp}/{languageCode}")
    fun getChampions(@Path("devId") devId: Int,
                     @Path("signature") signature: String,
                     @Path("session") session: String,
                     @Path("timestamp") timeStamp: String,
                     @Path("languageCode") languageCode: Int): Deferred<List<Champion>>
}