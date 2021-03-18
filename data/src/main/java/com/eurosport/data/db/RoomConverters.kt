package com.eurosport.data.db

import androidx.room.TypeConverter
import com.eurosport.data.response.SportResp
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RoomConverters {
    @TypeConverter
    fun saveSport(sportResp: SportResp?): String? {
        return Gson().toJson(sportResp)
    }

    @TypeConverter
    fun getSport(stringSport: String?): SportResp? {
        return Gson().fromJson(
            stringSport,
            object : TypeToken<SportResp?>() {}.type
        )
    }
}