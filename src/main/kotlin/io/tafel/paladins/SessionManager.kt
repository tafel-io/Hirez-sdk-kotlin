package io.tafel.paladins

import io.tafel.paladins.model.SessionResponse
import java.text.SimpleDateFormat
import java.util.*

class SessionManager(var sessionId: String = "", var lastSessionUpdatedTimeStamp: Date = Date()) {
    fun updateSession(sessionResponse: SessionResponse) {
        if (sessionResponse.sessionId.isBlank()) {
            return
        }
        sessionId = sessionResponse.sessionId
        lastSessionUpdatedTimeStamp = SimpleDateFormat("M/d/yyyy k:m:s a").parse(sessionResponse.timestamp)
    }

    fun isSessionValid() = sessionId.isNotBlank() && !isSessionExpired()

    private fun isSessionExpired(): Boolean {
        val diffInMinutes = Date().time - lastSessionUpdatedTimeStamp.time / (1000 * 60)
        return diffInMinutes >= SESSION_TIME_OUT
    }

    companion object {
        const val SESSION_TIME_OUT = 15
    }
}