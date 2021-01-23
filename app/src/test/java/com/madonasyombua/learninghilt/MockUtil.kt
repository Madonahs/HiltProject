package com.madonasyombua.learninghilt

import com.madonasyombua.learninghilt.data.StudentData


object MockUtil {
    private fun mockStudentData() =  StudentData(
        id = 1,
        school = "name",
        StudentFirstName = "first",
        examScore = "12",
        timestamp = "78675757575"
    )

    fun mockStudentDataList() = listOf(mockStudentData())

}