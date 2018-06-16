package io.tafel.paladins

import kotlinx.coroutines.experimental.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.IOException
import java.util.*


internal class PaladinsServiceTest {

    var devId: Int = 0
    var authKey: String = ""

    @BeforeEach
    fun setup() {
        val props = Properties()

        val inpStream = ClassLoader.getSystemResourceAsStream("test.properties")
        try {
            props.load(inpStream)
            devId = props.getProperty("dev.id").toInt()
            authKey = props.getProperty("auth.key")
        } catch (e: IOException) {
        }
    }

    @Test
    fun ping() {
        val pingResponse = runBlocking { PaladinsService(devId, authKey).ping() }
        assert(pingResponse.contains("Ping successful"))
    }

    @Test
    fun createSession() {
        val createSessionResponse = runBlocking { PaladinsService(devId, authKey).createSession() }
        print(createSessionResponse)
    }

    @Test
    fun getServerStatus() {
        val serverStatus = runBlocking { PaladinsService(devId, authKey).getServerStatus() }
        print(serverStatus)
    }
}