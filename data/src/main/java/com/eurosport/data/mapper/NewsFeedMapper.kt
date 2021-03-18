package com.eurosport.data.mapper

import com.eurosport.data.response.NewsFeedResp
import com.eurosport.data.response.VideoResp
import com.eurosport.domain.models.NewsFeed
import com.eurosport.domain.models.Video
import javax.inject.Inject

class  NewsFeedMapper @Inject constructor(val videoMapper: VideoMapper, val storyMapper: StoryMapper) {

    fun toNewsFeed(newsFeedResp: NewsFeedResp) : NewsFeed{
       return NewsFeed(videoMapper.toVideos(newsFeedResp.videoResp),storyMapper.toStories(newsFeedResp.storyResp))
    }
}