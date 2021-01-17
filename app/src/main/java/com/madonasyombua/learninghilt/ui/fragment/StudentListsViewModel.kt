package com.madonasyombua.learninghilt.ui.fragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.StudentRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class StudentListsViewModel @ViewModelInject constructor(
    studentRepository: StudentRepository
) : ViewModel() {

    private var _studentData = MutableLiveData<List<StudentData>>()
    val studentData: LiveData<List<StudentData>>
        get() = _studentData

    init {
        viewModelScope.launch {
            studentRepository.getStudents().collect { studentData ->
                _studentData.value = studentData
            }
        }
    }
}