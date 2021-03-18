package com.eurosport.data.db.dao

import androidx.room.*
import com.eurosport.data.response.VideoResp

@Dao
interface VideoDao {
    @Query("SELECT * FROM videos")
    fun getAll(): List<VideoResp>

    @Query("SELECT * FROM videos WHERE id=:Id")
    fun loadById(Id: Int): List<VideoResp>

    @Query("SELECT count(*) from videos")
    fun getVideosCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg videoResp: VideoResp?)

    @Delete
    fun delete(videoResp: VideoResp)
}