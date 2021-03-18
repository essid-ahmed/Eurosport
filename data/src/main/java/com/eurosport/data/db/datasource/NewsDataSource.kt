package com.eurosport.data.db.datasource

import com.eurosport.data.db.NewsDB
import com.eurosport.data.response.StoryResp
import com.eurosport.data.response.VideoResp
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NewsDataSource @Inject constructor (@ApplicationContext val context: android.content.Context) {
    val dataBase=NewsDB.invoke(context)

    fun insertVideos(videoResp: VideoResp)  {
        return dataBase.VideoDao().insert(videoResp)
    }

    fun getVideos(): List<VideoResp> {
        return  dataBase.VideoDao().getAll()
    }

    fun getVideosCount():Int{
        return dataBase.VideoDao().getVideosCount()
    }


    fun insertStories(storyResp: StoryResp)  {
        return dataBase.StoryDao().insert(storyResp)
    }

    fun getStories(): List<StoryResp> {
        return  dataBase.StoryDao().getAll()
    }

    fun getStoriesCount():Int{
        return dataBase.StoryDao().getStoriesCount()
    }

}