package com.eurosport.data.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eurosport.domain.models.Sport
import com.eurosport.domain.models.Story
import com.eurosport.domain.models.Video

@Entity(tableName = "videos")
data class VideoResp (@PrimaryKey var id:Int,  var title :String, var date :String, var sport: SportResp, var url :String,  var views :Int, var thumb: String)