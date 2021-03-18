package com.eurosport.data.db.dao

import androidx.room.*
import com.eurosport.data.response.SportResp

@Dao
interface SportDao {
    @Query("SELECT * FROM sports")
    fun getAll(): List<SportResp>

    @Query("SELECT * FROM sports WHERE id=:Id")
    fun loadById(Id: Int): List<SportResp>

    @Query("SELECT count(*) from sports")
    fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg sportResp: SportResp?)

    @Delete
    fun delete(sportResp: SportResp)
}