package com.eurosport.domain.result

import com.eurosport.domain.models.News

sealed class NewsResult {
    object Loading : NewsResult()
    data class Success(val newsList : List<News>):NewsResult()
    data class Failure(val throwable: Throwable) : NewsResult()
}