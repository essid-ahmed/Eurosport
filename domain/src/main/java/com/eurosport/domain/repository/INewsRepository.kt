package com.eurosport.domain.repository

import com.eurosport.domain.models.NewsFeed
import io.reactivex.Completable
import io.reactivex.Single

interface INewsRepository {
    fun getNewsFeed(): Single<NewsFeed>

    fun putNews(newsFeed: NewsFeed): Completable

    fun getLocalNewsFeed(): NewsFeed

    fun isDbEmpty() : Boolean
}