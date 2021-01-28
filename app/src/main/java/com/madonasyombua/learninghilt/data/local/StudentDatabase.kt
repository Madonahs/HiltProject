package com.madonasyombua.learninghilt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.madonasyombua.learninghilt.data.StudentData

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */
@Database(entities = [StudentData::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class StudentDatabase: RoomDatabase() {

    abstract fun studentDao(): StudentDao
}