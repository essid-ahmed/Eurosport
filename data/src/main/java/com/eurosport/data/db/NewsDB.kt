package com.eurosport.data.db

import androidx.room.Database
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eurosport.data.db.dao.SportDao
import com.eurosport.data.db.dao.StoryDao
import com.eurosport.data.db.dao.VideoDao
import com.eurosport.data.response.SportResp
import com.eurosport.data.response.StoryResp
import com.eurosport.data.response.VideoResp


@Database(entities = arrayOf(VideoResp::class,StoryResp::class,SportResp::class), version = 1)
@TypeConverters(RoomConverters::class)
abstract class NewsDB : RoomDatabase() {
    abstract fun StoryDao(): StoryDao
    abstract fun VideoDao(): VideoDao
    abstract fun SportDao():SportDao
    companion object {
        @Volatile private var instance: NewsDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            NewsDB::class.java, "news.db")
            .build()
    }
}