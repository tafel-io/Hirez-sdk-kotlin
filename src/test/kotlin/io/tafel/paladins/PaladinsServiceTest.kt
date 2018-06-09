package io.tafel.paladins

import kotlinx.coroutines.experimental.runBlocking
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PaladinsServiceTest {

    @Test
    fun ping() {
        val pingResponse = runBlocking { PaladinsService("", "").ping() }
        assert(pingResponse.contains("Ping successful"))
    }
}