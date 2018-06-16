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


data class Champion(
        @SerializedName("Ability1") var ability1Name: String,
        @SerializedName("Ability2") var ability2Name: String,
        @SerializedName("Ability3") var ability3Name: String,
        @SerializedName("Ability4") var ability4Name: String,
        @SerializedName("Ability5") var ability5Name: String,
        @SerializedName("AbilityId1") var abilityId1: Int,
        @SerializedName("AbilityId2") var abilityId2: Int,
        @SerializedName("AbilityId3") var abilityId3: Int,
        @SerializedName("AbilityId4") var abilityId4: Int,
        @SerializedName("AbilityId5") var abilityId5: Int,
        @SerializedName("Ability_1") var ability1: Ability,
        @SerializedName("Ability_2") var ability2: Ability,
        @SerializedName("Ability_3") var ability3: Ability,
        @SerializedName("Ability_4") var ability4: Ability,
        @SerializedName("Ability_5") var ability5: Ability,
        @SerializedName("ChampionAbility1_URL") var championAbility1URL: String,
        @SerializedName("ChampionAbility2_URL") var championAbility2URL: String,
        @SerializedName("ChampionAbility3_URL") var championAbility3URL: String,
        @SerializedName("ChampionAbility4_URL") var championAbility4URL: String,
        @SerializedName("ChampionAbility5_URL") var championAbility5URL: String,
        @SerializedName("ChampionCard_URL") var championCardURL: String,
        @SerializedName("ChampionIcon_URL") var championIconURL: String,
        @SerializedName("Cons") var cons: String,
        @SerializedName("Health") var health: Int,
        @SerializedName("Lore") var lore: String,
        @SerializedName("Name") var name: String,
        @SerializedName("OnFreeRotation") var onFreeRotation: String,
        @SerializedName("Pantheon") var pantheon: String,
        @SerializedName("Pros") var pros: String,
        @SerializedName("Roles") var roles: String,
        @SerializedName("Speed") var speed: Int,
        @SerializedName("Title") var title: String,
        @SerializedName("Type") var type: String,
        @SerializedName("abilityDescription1") var abilityDescription1: String,
        @SerializedName("abilityDescription2") var abilityDescription2: String,
        @SerializedName("abilityDescription3") var abilityDescription3: String,
        @SerializedName("abilityDescription4") var abilityDescription4: String,
        @SerializedName("abilityDescription5") var abilityDescription5: String,
        @SerializedName("id") var id: Int,
        @SerializedName("latestChampion") var latestChampion: String,
        @SerializedName("ret_msg") var retMsg: Any
)

data class Ability(
        @SerializedName("Description") var description: String,
        @SerializedName("Id") var id: Int,
        @SerializedName("Summary") var summary: String,
        @SerializedName("URL") var uRL: String
)

enum class Language(val code: Int) {
    ENGLISH(1),
    GERMAN(2),
    FRENCH(3),
    CHINESE(5),
    SPANISH(7),
    SPANISH_LATIN_AMERICA(9),
    PORTUGUESE(10),
    RUSSIAN(11),
    POLISH(12),
    TURKISH(13)
}