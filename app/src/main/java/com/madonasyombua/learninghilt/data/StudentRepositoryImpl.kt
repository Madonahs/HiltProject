package com.madonasyombua.learninghilt.data

import com.madonasyombua.learninghilt.data.local.StudentDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentDao: StudentDao
) : StudentRepository {

    override fun getStudents(): Flow<List<StudentData>> {
        return studentDao.loadAllStudentsLists()
    }

    init{
        GlobalScope.launch {
            studentDao.insertAllStudents(provideStudentData())
        }
    }

    private fun provideStudentData() = listOf(
        StudentData(
            1,
            "Stanford University",
            "Alice Johnson",
            "100%",
            Date()
        ),
        StudentData(
            2,
            "Auburn University",
            "Malika Todd",
            "100%",
            Date()
        ),
        StudentData(
            3,
            "Howard University",
            "Brody Nelson",
            "99%",
            Date()
        ),
        StudentData(
            4,
            "MIT",
            "Mercy Smith",
            "89%",
            Date()
        ),
        StudentData(
            5,
            "Cornell University",
            "Joshua Val",
            "100%",
            Date()
        )
    )
}
