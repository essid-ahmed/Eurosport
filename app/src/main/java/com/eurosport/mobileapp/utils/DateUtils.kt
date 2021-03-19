package com.eurosport.mobileapp.utils

import android.content.Context
import java.sql.Timestamp


class DateUtils {
    companion object DateUtil{
        fun getDif(context: Context, publishDate: String) : String
        {
            val publishTimesTamp= Timestamp(publishDate.toBigDecimal().toLong())
            val nowTimesTamp = Timestamp(System.currentTimeMillis())
            // get time difference in seconds
            val milliseconds: Long = nowTimesTamp.time - publishTimesTamp.time

            val seconds = milliseconds.toInt() / 1000
            val hours = seconds / 3600
            val minutes = seconds % 3600 / 60

            if(seconds in 1..59)
            {
                return "$seconds seconds"
            }
            if(minutes in 1..59)
            {
                return "$minutes minutes"
            }
            if(hours in 1..24)
            {
                return "$hours hours"
            }
            /*if(days in 1..30)
            {
                return "$days days"
            }
            if(months in 1..12)
            {
                return "$months months"
            }*/
            //return "$years years"
        return "001";
        }
    }
}