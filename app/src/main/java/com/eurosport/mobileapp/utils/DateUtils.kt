package com.eurosport.mobileapp.utils

import android.content.Context
import android.text.format.DateFormat
import org.joda.time.*
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter
import java.util.*


class DateUtils {
    companion object DateUtil{
        fun getDif(context: Context, publishDate: String) : String
        {

            val formatter: DateTimeFormatter = DateTimeFormat.forPattern("dd-MM-yyyy")

            val stringDate = getDate(publishDate.toBigDecimal().toLong())
            val startDate: DateTime =formatter.parseDateTime(stringDate)

            val endDate = DateTime()
            val days = Days.daysBetween(startDate,endDate)
            val years =Years.yearsBetween(startDate,endDate)
            val hours = Hours.hoursBetween(startDate,endDate)
            val minutes =Minutes.minutesBetween(startDate,endDate)
            val months =Months.monthsBetween(startDate,endDate)
            val seconds =Seconds.secondsBetween(startDate,endDate)
            if(years>Years.ZERO)
            {
                return "${years.years} years ago"
            }
            if(months>Months.ZERO)
            {
                return "${months.months} months ago"
            }
            if(days>Days.ZERO)
            {
                return "${days.days} days ago"
            }
            if(hours>Hours.ZERO)
            {
                return "${hours.hours} hours ago"
            }
            if(minutes>Minutes.ZERO)
            {
                return "${minutes.minutes} minutes ago"
            }
            return "${seconds.seconds} seconds ago"
        }
        private fun getDate(time: Long): String? {
            val cal = Calendar.getInstance(Locale.ENGLISH)
            cal.timeInMillis = time * 1000
            return DateFormat.format("dd-MM-yyyy", cal).toString()
        }
    }
}