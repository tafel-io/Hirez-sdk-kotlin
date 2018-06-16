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

data class PlayerInfo(
        @SerializedName("Created_Datetime") var createdDatetime: String,
        @SerializedName("Id") var id: Int,
        @SerializedName("Last_Login_Datetime") var lastLoginDatetime: String,
        @SerializedName("Leaves") var leaves: Int,
        @SerializedName("Level") var level: Int,
        @SerializedName("Losses") var losses: Int,
        @SerializedName("MasteryLevel") var masteryLevel: Int,
        @SerializedName("Name") var name: String,
        @SerializedName("Personal_Status_Message") var personalStatusMessage: String,
        @SerializedName("RankedConquest") var rankedConquest: RankedConquest,
        @SerializedName("Region") var region: String,
        @SerializedName("TeamId") var teamId: Int,
        @SerializedName("Team_Name") var teamName: String,
        @SerializedName("Tier_Conquest") var tierConquest: Int,
        @SerializedName("Total_Achievements") var totalAchievements: Int,
        @SerializedName("Total_Worshippers") var totalWorshippers: Int,
        @SerializedName("Wins") var wins: Int,
        @SerializedName("ret_msg") var retMsg: Any
)

data class RankedConquest(
        @SerializedName("Leaves") var leaves: Int,
        @SerializedName("Losses") var losses: Int,
        @SerializedName("Name") var name: String,
        @SerializedName("Points") var points: Int,
        @SerializedName("PrevRank") var prevRank: Int,
        @SerializedName("Rank") var rank: Int,
        @SerializedName("Rank_Stat_Conquest") var rankStatConquest: Any,
        @SerializedName("Rank_Stat_Duel") var rankStatDuel: Any,
        @SerializedName("Rank_Stat_Joust") var rankStatJoust: Any,
        @SerializedName("Season") var season: Int,
        @SerializedName("Tier") var tier: Int,
        @SerializedName("Trend") var trend: Int,
        @SerializedName("Wins") var wins: Int,
        @SerializedName("player_id") var playerId: Any,
        @SerializedName("ret_msg") var retMsg: Any
)