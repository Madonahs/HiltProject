package com.madonasyombua.learninghilt.data

import kotlinx.coroutines.flow.Flow

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

interface StudentRepository {
    fun getStudents(): Flow<List<StudentData>>
}