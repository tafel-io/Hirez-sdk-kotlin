package io.tafel.paladins.model

import com.google.gson.annotations.SerializedName

data class SessionResponse(
        @SerializedName("ret_msg") var retMsg: String,
        @SerializedName("session_id") var sessionId: String,
        @SerializedName("timestamp") var timestamp: String
)