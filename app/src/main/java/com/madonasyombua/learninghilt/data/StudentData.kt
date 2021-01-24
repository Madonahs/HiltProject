package com.madonasyombua.learninghilt.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

@Entity(tableName = "studentList")
data class StudentData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var school: String?,
    var StudentFirstName: String?,
    var examScore: String?,
    var timestamp: Date?
)