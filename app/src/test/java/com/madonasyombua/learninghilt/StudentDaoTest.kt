package com.madonasyombua.learninghilt

import com.madonasyombua.learninghilt.data.local.StudentDao
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

//https://developer.android.com/kotlin/flow/test

@RunWith(RobolectricTestRunner::class)
class StudentDaoTest : LocalDbTest(){

    private lateinit var studentDao: StudentDao
    @Before
    fun `init `(){
        studentDao = db.studentDao()
    }

    @Test
    fun `insert student data in the db`() = runBlocking {
        val mockData = MockUtil.mockStudentDataList()
        studentDao.insertAllStudents(mockData)




    }

}