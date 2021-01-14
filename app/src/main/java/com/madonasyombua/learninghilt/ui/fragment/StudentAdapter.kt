package com.madonasyombua.learninghilt.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.databinding.StudentListsBinding

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

internal class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    private var studentList: List<StudentData> = ArrayList()

    class StudentViewHolder(private val binding: StudentListsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(students: StudentData) {
            binding.studentSchool.text = students.school
            binding.studentName.text = students.StudentFirstName
            binding.studentScore.text = students.examScore
            binding.time.text = students.timestamp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding =
            StudentListsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students = studentList[position])
    }

    override fun getItemCount(): Int = studentList.size

    fun submitStudentList(students: List<StudentData>) {
        studentList = students
        notifyDataSetChanged()
    }

}