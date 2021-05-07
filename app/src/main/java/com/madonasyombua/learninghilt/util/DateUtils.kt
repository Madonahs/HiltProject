package com.madonasyombua.learninghilt.util

import android.content.Context
import com.madonasyombua.learninghilt.R
import com.madonasyombua.learninghilt.data.StudentData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    fun getFormattedDate(
            context: Context,
            studentData: StudentData,
            currentDate: Date
    ): String {


        studentData.timestamp?.let { callStartedAt ->
            return when {
                !callStartedAt.before(getMidnight(currentDate, 0)) -> {
                    val dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT)
                    dateFormat.format(callStartedAt)
                }
                !callStartedAt.before(getMidnight(currentDate, 1)) -> {
                    context.getString(R.string.yesterday)
                }
                !callStartedAt.before(getMidnight(currentDate, 6))->{
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

    private fun getMidnight(currentDate: Date, daysAgo: Int) =
            Calendar.getInstance().apply {
                time = currentDate
                add(Calendar.DATE, -1 * daysAgo)
                set(Calendar.HOUR_OF_DAY, 0)
                set(Calendar.MINUTE, 0)
                set(Calendar.SECOND, 0)
                set(Calendar.MILLISECOND, 0)
            }.time

    companion object {
        private const val DATE_FORMAT_DAY_NAME_IN_WEEK = "EEEE"
    }
}