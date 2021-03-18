package com.eurosport.data.api

import com.eurosport.data.response.NewsFeedResp
import com.eurosport.domain.models.NewsFeed
import io.reactivex.Single
import retrofit2.http.GET

interface EndPoint {
    @GET("/api/json-storage/bin/edfefba")
    fun getNewsFeed(): Single<NewsFeedResp>
}