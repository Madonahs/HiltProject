package com.madonasyombua.learninghilt.ui.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.StudentRepository

class StudentListsViewModel @ViewModelInject constructor(private val studentRepository: StudentRepository) : ViewModel() {
    val studentData: LiveData<List<StudentData>> = studentRepository.studentRepository
}