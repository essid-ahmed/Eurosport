package com.eurosport.data.mapper

import com.eurosport.data.response.StoryResp
import com.eurosport.data.response.VideoResp
import com.eurosport.domain.models.Story
import com.eurosport.domain.models.Video
import javax.inject.Inject

class  StoryMapper @Inject constructor(private val sportMapper: SportMapper) {

    fun toStories(list: List<StoryResp>) : List<Story>{
       return list.map { toStory(it) }
    }

    private fun toStory(resp: StoryResp):Story{
        return Story(resp.id,resp.title,resp.date,sportMapper.toSport(resp.sport),resp.image,resp.teaser,resp.author)
    }
    fun toStoryResp(story: Story): StoryResp{
        return StoryResp(story.id,story.title,story.date,sportMapper.toSportResp(story.sport),story.image,story.teaser,story.author)
    }
}