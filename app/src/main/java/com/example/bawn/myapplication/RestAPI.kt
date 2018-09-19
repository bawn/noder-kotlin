package com.example.bawn.noder_kotlin

import com.example.bawn.myapplication.CollectionApi
import com.example.bawn.myapplication.Me
import com.example.bawn.myapplication.ProfileApi
import com.example.bawn.myapplication.ResponseDataWrapper
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable

/**
 * Created by bawn on 13/07/2017.
 */

class RestAPI {

    private val topicsApi: TopicsApi
    private val recentTopics: ProfileApi
    private val collectionApi: CollectionApi

    init {

        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl("https://cnodejs.org/api/v1/")
                .build()

        topicsApi = retrofit.create(TopicsApi::class.java)
        recentTopics = retrofit.create(ProfileApi::class.java)
        collectionApi = retrofit.create(CollectionApi::class.java)
    }

    fun getTopics(): Observable<ResponseListWrapper<Topic>> {
        return topicsApi.getTopics()
    }

    fun getRecentTopics(): Observable<ResponseDataWrapper<Me>> {
        return recentTopics.getProfile()
    }

    fun getCollectionList(): Observable<ResponseListWrapper<Topic>> {
        return collectionApi.getCollection()
    }
}