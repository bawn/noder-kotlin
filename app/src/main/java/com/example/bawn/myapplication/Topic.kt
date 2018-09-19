package com.example.bawn.noder_kotlin

/**
 * Created by bawn on 14/07/2017.
 */

data class ResponseListWrapper<T>(
        val success: Boolean,
        val data: List<T>
)

data class Topic (
        val id: String,
        val author_id: String,
        val tab: String,
        val content: String,
        val title: String,
        val last_reply_at: String,
        val good: Boolean,
        val top: Boolean,
        val reply_count: Int,
        val visit_count: Int,
        val create_at: String,
        val author: Author
)
