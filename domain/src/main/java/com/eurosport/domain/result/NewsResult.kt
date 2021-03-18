package com.eurosport.domain.result

import com.eurosport.domain.models.NewsFeed

sealed class NewsResult {
    object Loading : NewsResult()
    data class Success(val newsFeed : NewsFeed):NewsResult()
    data class Failure(val throwable: Throwable) : NewsResult()
}