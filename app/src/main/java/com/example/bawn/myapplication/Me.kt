package com.example.bawn.myapplication

import com.example.bawn.noder_kotlin.Topic


data class ResponseDataWrapper<T>(
        val success: Boolean,
        val data: T
)

data class Me (
    val loginname: String,
    val avatar_url: String,
    val githubUsername: String,
    val create_at: String,
    val score: Int,
    val last_reply_at: String = "",
    val recent_topics: List<Topic>,
    val recent_replies: List<Topic>
)