package com.eurosport.data.response

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eurosport.domain.models.Sport
import com.eurosport.domain.models.Story
import com.eurosport.domain.models.Video

@Entity(tableName = "sports")
data class SportResp (@PrimaryKey var id:Int, var name :String)