package com.eurosport.data.repositoryImp

import com.eurosport.data.api.EuroSportApi
import com.eurosport.data.db.datasource.NewsDataSource
import com.eurosport.data.mapper.NewsFeedMapper
import com.eurosport.data.mapper.SportMapper
import com.eurosport.data.mapper.VideoMapper
import com.eurosport.data.mapper.StoryMapper
import com.eurosport.domain.models.NewsFeed
import com.eurosport.domain.repository.INewsRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class NewsRepositoryImp @Inject constructor(private val api:EuroSportApi, private val dataSource: NewsDataSource,private val newsFeedMapper: NewsFeedMapper,private val storyMapper: StoryMapper, private val videoMapper: VideoMapper) : INewsRepository {

    override fun getNewsFeed(): Single<NewsFeed> {
        return api.getNewsFeed().map {
            newsFeedMapper.toNewsFeed(it) }
    }

    override fun putNews(newsFeed: NewsFeed): Completable {
       return Completable.fromAction {
           putVideos(newsFeed)
           putStories(newsFeed)
       }
    }

    private fun putVideos(newsFeed: NewsFeed) {
        for (video in newsFeed.videos) {
            dataSource.insertVideos(videoMapper.toVideoResp(video))
        }
    }
    private fun putStories(newsFeed: NewsFeed) {
        for (story in newsFeed.stories) {
            dataSource.insertStories(storyMapper.toStoryResp(story))
        }
    }

    override fun getLocalNewsFeed(): NewsFeed {
        TODO("Not yet implemented")
    }

    override fun isDbEmpty(): Boolean {
      return  (dataSource.getStoriesCount()==0 && dataSource.getVideosCount()==0)
    }


}