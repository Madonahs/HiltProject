package com.madonasyombua.learninghilt

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.StudentRepository
import com.madonasyombua.learninghilt.ui.fragment.StudentListsViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

//https://github.com/mockito/mockito-kotlin
class StudentListsViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @Test
    fun `when student data is loaded,the expected data is returned`() =
        runBlockingTest {
            val studentDataExpected = listOf(
                StudentData(
                    id = 1,
                    school = "name",
                    StudentFirstName = "first",
                    examScore = "12",
                    timestamp = "78675757575"
                )
            )
            val studentListsViewModel = StudentListsViewModel(
                studentRepository = mock<StudentRepository>().apply {
                    whenever(getStudents()).thenReturn(flowOf(studentDataExpected))
                }
            )

            studentListsViewModel.studentData.observeForever { studentDataActual ->
                assert(studentDataActual == studentDataExpected) {
                    println("Expected $studentDataExpected but got $studentDataActual")
                }
            }
        }

}