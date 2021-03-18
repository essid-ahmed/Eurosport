package com.eurosport.data.response

import com.google.gson.annotations.SerializedName

data class NewsFeedResp (@SerializedName("videos") val videoResp: List<VideoResp>, @SerializedName("stories")val storyResp: List<StoryResp> )