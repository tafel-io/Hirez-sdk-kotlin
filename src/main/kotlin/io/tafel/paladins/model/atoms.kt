package io.tafel.paladins.model

import com.google.gson.annotations.SerializedName

data class SessionResponse(
        @SerializedName("ret_msg") var retMsg: String,
        @SerializedName("session_id") var sessionId: String,
        @SerializedName("timestamp") var timestamp: String
)

data class ServerStatusResponse(
        @SerializedName("entry_datetime") var entryDatetime: String,
        @SerializedName("ret_msg") var retMsg: Any,
        @SerializedName("status") var status: String,
        @SerializedName("version") var version: String
)


data class DataUsageResponse(
        @SerializedName("Active_Sessions") var activeSessions: Int,
        @SerializedName("Concurrent_Sessions") var concurrentSessions: Int,
        @SerializedName("Request_Limit_Daily") var requestLimitDaily: Int,
        @SerializedName("Session_Cap") var sessionCap: Int,
        @SerializedName("Session_Time_Limit") var sessionTimeLimit: Int,
        @SerializedName("Total_Requests_Today") var totalRequestsToday: Int,
        @SerializedName("Total_Sessions_Today") var totalSessionsToday: Int,
        @SerializedName("ret_msg") var retMsg: Any
)

data class Friend(
        @SerializedName("account_id") var accountId: String,
        @SerializedName("name") var name: String,
        @SerializedName("player_id") var playerId: String,
        @SerializedName("ret_msg") var retMsg: Any
)