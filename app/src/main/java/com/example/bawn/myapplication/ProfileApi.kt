package com.example.bawn.myapplication

import com.example.bawn.noder_kotlin.ResponseListWrapper
import com.example.bawn.noder_kotlin.Topic
import retrofit2.http.GET
import rx.Observable

/**
 * Created by bawn on 13/07/2017.
 */


interface ProfileApi {
    @GET("user/bawn/")
    fun getProfile(): Observable<ResponseDataWrapper<Me>>
}

interface CollectionApi {
    @GET("topic_collect/bawn")
    fun getCollection(): Observable<ResponseListWrapper<Topic>>
}
