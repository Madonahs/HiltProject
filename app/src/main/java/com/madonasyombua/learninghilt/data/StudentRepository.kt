package com.madonasyombua.learninghilt.data

import kotlinx.coroutines.flow.Flow
import com.madonasyombua.learninghilt.data.helpers.Result

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

interface StudentRepository {
    suspend fun getStudents(): Flow<List<StudentData>>
}