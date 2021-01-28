package com.madonasyombua.learninghilt.ui.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.madonasyombua.learninghilt.R

class ListOfStudentFragment : Fragment() {

    companion object {
        fun newInstance() = ListOfStudentFragment()
    }

    private lateinit var viewModel: ListOfStudentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_of_student_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListOfStudentViewModel::class.java)
        // TODO: Use the ViewModel
    }

}