package com.madonasyombua.learninghilt.data

import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.StudentRepository
import com.madonasyombua.learninghilt.data.local.StudentDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.*

class FakeDataRepository : StudentRepository {

    override fun getStudents(): Flow<List<StudentData>> {
        return flow {
            emit(listOf(StudentData(
                id = 1,
                school = "Madona Syombua Test",
                StudentFirstName = "first",
                examScore = "100",
                timestamp = Date(123323231)
            )))
        }
    }

}