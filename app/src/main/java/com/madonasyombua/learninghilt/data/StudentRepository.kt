package com.madonasyombua.learninghilt.data

import androidx.lifecycle.LiveData

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

interface StudentRepository {
    val studentRepository: LiveData<List<StudentData>>
}