package com.madonasyombua.learninghilt.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.madonasyombua.learninghilt.R
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.databinding.StudentListsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentListsFragment : Fragment() {

    private val viewModel: StudentListsViewModel by viewModels()
    private lateinit var studentListAdapter: StudentAdapter
    private var binding: StudentListsFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StudentListsFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpStudentAdapter()
        viewModel.studentData.observe(viewLifecycleOwner, observer)
    }

    private val observer = Observer<List<StudentData>> { studentList ->
        binding?.studentList?.visibility = if (studentList.isEmpty()) View.GONE else View.VISIBLE
        binding?.noStudentList?.visibility = if (studentList.isEmpty()) View.VISIBLE else View.GONE
        studentListAdapter.submitStudentList(studentList)
    }

    private fun setUpStudentAdapter() {
        studentListAdapter = StudentAdapter()
        binding?.studentList?.adapter = studentListAdapter
    }
}