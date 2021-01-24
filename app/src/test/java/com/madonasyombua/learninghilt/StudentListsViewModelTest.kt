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
@ExperimentalCoroutinesApi
class StudentListsViewModelTest {


    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `when student data is loaded,the expected data is returned`() =
        runBlockingTest {
            val studentListsViewModel = StudentListsViewModel(
                studentRepository = mock<StudentRepository>().apply {
                    whenever(getStudents()).thenReturn(flowOf(MockUtil.mockStudentDataList()))
                }
            )

            studentListsViewModel.studentData.observeForever { studentDataActual ->
                assert(studentDataActual == MockUtil.mockStudentDataList())
            }
        }

}