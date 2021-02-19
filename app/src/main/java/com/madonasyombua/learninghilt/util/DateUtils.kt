package com.madonasyombua.learninghilt.util

import com.madonasyombua.learninghilt.data.StudentData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    fun getFormattedDate(
            studentData: StudentData,
            currentDate: Date
    ): String {
        studentData.timestamp?.let { callStartedAt ->
            val midnightToday = Calendar.getInstance().apply {
                time = currentDate
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }
            val dayOfWeek = Calendar.getInstance().apply {
                time = currentDate
                add(Calendar.DATE, -6)
            }
            return when {
                (callStartedAt.after(midnightToday.time)) -> {
                    val dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT)
                    dateFormat.format(callStartedAt)
                }
                (callStartedAt.after(dayOfWeek.time)) -> {
                    val dateFormat =
                            SimpleDateFormat(DATE_FORMAT_DAY_NAME_IN_WEEK, Locale.getDefault())
                    dateFormat.format(callStartedAt)
                }
                else -> {
                    //Use getDateInstance to get the normal date format for that country.
                    val dateFormat = DateFormat.getDateInstance(DateFormat.SHORT)
                    dateFormat.format(callStartedAt)
                }
            }
        }
        return ""
    }
    companion object {
        private const val DATE_FORMAT_DAY_NAME_IN_WEEK = "EEEE"
    }
}