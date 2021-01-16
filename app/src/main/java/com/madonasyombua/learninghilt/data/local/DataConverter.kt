package com.madonasyombua.learninghilt.data.local

import androidx.room.TypeConverter
import java.util.*

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

object DateConverter {
    @JvmStatic
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @JvmStatic
    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}