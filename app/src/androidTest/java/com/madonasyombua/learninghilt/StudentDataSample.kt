package com.madonasyombua.learninghilt

import com.madonasyombua.learninghilt.data.StudentData
import java.util.*

object StudentDataSample {
    private fun mockStudentData() = StudentData(
        id = 1,
        school = "name",
        StudentFirstName = "first",
        examScore = "12",
        timestamp = Date(123323231)
    )

    fun mockStudentDataList() = listOf(mockStudentData())

}