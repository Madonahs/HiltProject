package com.madonasyombua.learninghilt.util

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class DateUtils {

    companion object{
        private const val DATE_FORMAT_YEAR = "MM/dd/yyyy"
        private const val DATE_FORMAT_TIME = "hh:mm a"

        fun getDate(date:Long){
            val nowCal = Calendar.getInstance()
            val dateCal = Calendar.getInstance().apply {
                //just for test, replace with your date timestamp
                timeInMillis += TimeUnit.DAYS.toMillis(9)
            }

            val nowDay = TimeUnit.MILLISECONDS.toDays(nowCal.timeInMillis)
            val dateDay = TimeUnit.MILLISECONDS.toDays(dateCal.timeInMillis)

            when {
                (dateDay - nowDay) <= 1L -> {
                    val formatter = SimpleDateFormat(DATE_FORMAT_TIME, Locale.getDefault())
                    val dateStr = formatter.format(dateCal.time)
                    println(dateStr)
                }

                (dateDay - nowDay) <= 6L -> {
                    val dateStr = dateCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH)
                    println(dateStr)
                }

                else ->{
                    val formatter = SimpleDateFormat(DATE_FORMAT_YEAR, Locale.getDefault())
                    val dateStr = formatter.format(dateCal.time)
                    println(dateStr)
                }
            }
        }
    }
}