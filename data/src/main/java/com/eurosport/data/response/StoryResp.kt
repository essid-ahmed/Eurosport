package com.eurosport.data.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eurosport.domain.models.Sport


@Entity(tableName = "stories")
data class StoryResp ( @PrimaryKey var id:Int,  var title :String, var date :String, var sport: SportResp,var image :String,var teaser :String,var author :String)