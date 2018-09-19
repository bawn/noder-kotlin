package com.example.bawn.noder_kotlin

import retrofit2.http.GET
import rx.Observable

/**
 * Created by bawn on 13/07/2017.
 */


interface TopicsApi {
    @GET("topics/")
    fun  getTopics(): Observable<ResponseListWrapper<Topic>>
}