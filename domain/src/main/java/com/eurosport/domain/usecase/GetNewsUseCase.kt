package com.eurosport.domain.usecase

import android.util.Log
import com.eurosport.domain.models.News
import com.eurosport.domain.models.NewsFeed
import com.eurosport.domain.repository.INewsRepository
import com.eurosport.domain.result.NewsResult
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(val repo: INewsRepository){

    fun execute(): Observable<NewsResult> {
        return   repo.getNewsFeed()
            .toObservable()
            .map { onSuccessGettingNews(it) }
            .onErrorReturn { onFailureGettingNews(it) }
            .startWith(NewsResult.Loading)
    }

    private fun onSuccessGettingNews(newsFeed: NewsFeed) : NewsResult{
        var newsResultList =ArrayList<News>()
        repo.putNews(newsFeed).subscribeOn(Schedulers.io())
            .subscribe({ Log.e("Success","false")},{})
        newsResultList.addAll(newsFeed.videos)
        newsResultList.addAll(newsFeed.stories)
        newsResultList.sortBy { it.date }
        return NewsResult.Success(newsResultList)
    }

    private fun onFailureGettingNews(throwable: Throwable):NewsResult{
        if(!repo.isDbEmpty()) {
            var newsFeed=repo.getLocalNewsFeed()
            var newsResultList =ArrayList<News>()
            newsResultList.addAll(newsFeed.videos)
            newsResultList.addAll(newsFeed.stories)
            newsResultList.sortBy { it.date }
            return NewsResult.Success(newsResultList)
        }
        return NewsResult.Failure(throwable)
    }
}