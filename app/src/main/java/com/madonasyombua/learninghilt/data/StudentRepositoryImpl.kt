package com.madonasyombua.learninghilt.data

import com.madonasyombua.learninghilt.data.local.StudentDao
import kotlinx.coroutines.flow.Flow
import java.util.*
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentDao: StudentDao
) : StudentRepository {

    override suspend fun getStudents(): Flow<List<StudentData>> {
        studentDao.insertAllStudents(provideStudentData())
        return studentDao.loadAllStudentsLists()
    }

    private fun provideStudentData() = listOf(
        StudentData(
            1,
            "Mody",
            "100",
            "11:22pm",
            Date().time.toString()
        ),
        StudentData(
            2,
            "Mody",
            "100",
            "11:22pm",
            Date().time.toString()
        ),
        StudentData(
            3,
            "Mody",
            "100",
            "11:22pm",
            Date().time.toString()
        ),
        StudentData(
            4,
            "Mody",
            "100",
            "11:22pm",
            Date().time.toString()
        ),
        StudentData(
            5,
            "Mody",
            "100",
            "11:22pm",
            Date().time.toString()
        )
    )
}
