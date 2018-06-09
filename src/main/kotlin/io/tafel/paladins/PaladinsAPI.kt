package io.tafel.paladins

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface PaladinsAPI {
    @GET("pingJson")
    fun pingAPI(): Deferred<String>

}