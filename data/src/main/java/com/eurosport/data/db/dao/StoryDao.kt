package com.eurosport.data.db.dao

import androidx.room.*
import com.eurosport.data.response.StoryResp
import com.eurosport.data.response.VideoResp

@Dao
interface StoryDao {
    @Query("SELECT * FROM stories")
    fun getAll(): List<StoryResp>

    @Query("SELECT * FROM stories WHERE id=:Id")
    fun loadById(Id: Int): List<StoryResp>

    @Query("SELECT count(*) from stories")
    fun getStoriesCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg storyResp: StoryResp)

    @Delete
    fun delete(storyResp: StoryResp)
}