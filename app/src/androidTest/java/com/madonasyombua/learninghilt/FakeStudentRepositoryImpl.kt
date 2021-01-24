package com.madonasyombua.learninghilt

import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.StudentRepository
import com.madonasyombua.learninghilt.data.local.StudentDao
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FakeStudentRepositoryImpl(private val dao: StudentDao) : StudentRepository {

    init{
        GlobalScope.launch {
            dao.insertAllStudents(StudentDataSample.mockStudentDataList())
        }
    }

    override fun getStudents(): Flow<List<StudentData>> = dao.loadAllStudentsLists()
}