package com.eurosport.data.mapper

import com.eurosport.data.response.VideoResp
import com.eurosport.domain.models.Video
import javax.inject.Inject

class  VideoMapper @Inject constructor(private val sportMapper: SportMapper) {

    fun toVideos(list: List<VideoResp>) : List<Video>{
       return list.map { toVideo(it) }
    }

    private fun toVideo(resp: VideoResp):Video{
        return Video(resp.id,resp.title,resp.date,sportMapper.toSport(resp.sport),resp.url,resp.views,resp.thumb)
    }
    fun toVideoResp(video: Video): VideoResp{
        return VideoResp(video.id,video.title,video.date,sportMapper.toSportResp(video.sport),video.url,video.views,video.thumb)
    }
}