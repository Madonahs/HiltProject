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
            provideStudentData().forEach{ students -> studentDao.insertAllStudents(students)}
        }
    }

/*  override suspend fun getStudents(): Flow<List<StudentData>> = flow {
      studentDao.insertAllStudents(provideStudentData())
      emit(studentDao.loadAllStudentsLists())
      return@flow
  }*/

    private fun provideStudentData() = listOf(
        StudentData(
            1,
            "Mody",
            "100",
            "11:22pm",
            Date()
        ),
        StudentData(
            2,
            "Mody",
            "100",
            "11:22pm",
            Date()
        ),
        StudentData(
            3,
            "Mody",
            "100",
            "11:22pm",
            Date()
        ),
        StudentData(
            4,
            "Mody",
            "100",
            "11:22pm",
            Date()
        ),
        StudentData(
            5,
            "Mody",
            "100",
            "11:22pm",
            Date()
        )
    )
}
