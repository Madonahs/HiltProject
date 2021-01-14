package com.madonasyombua.learninghilt.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StudentRepositoryImpl : StudentRepository {

    override val studentRepository: LiveData<List<StudentData>> =
        MutableLiveData(
            listOf(
                StudentData(
                    "MIT",
                    "Mody",
                    "100",
                    "11:22pm"
                ),
                StudentData(
                    "MIT",
                    "Mody",
                    "100",
                    "11:22pm"
                ),
                StudentData(
                    "MIT",
                    "Mody",
                    "100",
                    "11:22pm"
                ),
                StudentData(
                    "MIT",
                    "Mody",
                    "100",
                    "11:22pm"
                ),
                StudentData(
                    "MIT",
                    "Mody",
                    "100",
                    "11:22pm"
                ),
            )
        )

}