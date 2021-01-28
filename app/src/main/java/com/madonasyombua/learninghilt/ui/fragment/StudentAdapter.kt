package com.madonasyombua.learninghilt.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.databinding.StudentListsBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

class StudentAdapter : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var studentList: List<StudentData> = ArrayList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    class StudentViewHolder(private val binding: StudentListsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(students: StudentData) {
            binding.studentSchool.text = students.school
            binding.studentName.text = students.StudentFirstName
            binding.studentScore.text = students.examScore
            val updated = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
            binding.time.text = updated.format(students.timestamp)
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

    companion object{
        const val DATE_FORMAT = "dd/MM/yyyy"
    }

}