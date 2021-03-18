package com.eurosport.data.api

import com.eurosport.data.response.NewsFeedResp
import com.eurosport.domain.models.NewsFeed
import io.reactivex.Single
import javax.inject.Inject

class EuroSportApi @Inject constructor (private val endPoint: EndPoint){
    fun getNewsFeed():Single<NewsFeedResp>
    {
        return endPoint.getNewsFeed()
    }
}