package io.tafel.paladins

import kotlinx.coroutines.experimental.runBlocking
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import java.io.IOException
import java.util.*

//TODO make these tests do something instead of just printing output
@TestInstance(PER_CLASS)
internal class PaladinsServiceTest {

    var devId: Int = 0
    var authKey: String = ""
    lateinit var paladinsService: PaladinsService

    @BeforeAll

    fun setup() {
        val props = Properties()

        val inpStream = ClassLoader.getSystemResourceAsStream("test.properties")
        try {
            props.load(inpStream)
            devId = props.getProperty("dev.id").toInt()
            authKey = props.getProperty("auth.key")
        } catch (e: IOException) {
        } finally {
            paladinsService = PaladinsService(devId, authKey)
        }
    }

    @Test
    fun ping() {
        val pingResponse = runBlocking { paladinsService.ping() }
        assert(pingResponse.contains("Ping successful"))
    }

    @Test
    fun createSession() {
        val createSessionResponse = runBlocking { paladinsService.createSession() }
        println(createSessionResponse)
    }

    @Test
    fun getServerStatus() {
        val serverStatus = runBlocking { paladinsService.getServerStatus() }
        println(serverStatus)
    }

    @Test
    fun getDataUsed() {
        val dataUsed = runBlocking { paladinsService.getDataUsed() }
        println(dataUsed)
    }

    @Test
    fun getFriends() {
        val friends = runBlocking { paladinsService.getFriends("PGPGPGPG") }
        println(friends)
    }

    @Test
    fun getPlayer() {
        val player = runBlocking { paladinsService.getPlayer("PGPGPGPG") }
        println(player)
    }

    @Test
    fun getChampions() {
        val champions = runBlocking { paladinsService.getChampions() }
        println(champions)
    }
}