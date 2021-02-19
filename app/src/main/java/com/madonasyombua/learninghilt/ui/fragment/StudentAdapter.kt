package com.madonasyombua.learninghilt.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.databinding.StudentListsBinding
import com.madonasyombua.learninghilt.util.DateUtil
import com.madonasyombua.learninghilt.util.TimeProvider
import kotlin.collections.ArrayList


/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

class StudentAdapter(
       private val timeProvider: TimeProvider
)
         : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    var studentList: List<StudentData> = ArrayList()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    class StudentViewHolder(private val binding: StudentListsBinding, private val timeProvider: TimeProvider) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: StudentData) {
            binding.studentSchool.text = data.school
            binding.studentName.text = data.StudentFirstName
            binding.studentScore.text = data.examScore
            DateUtil().getFormattedDate(data, timeProvider.getCurrentDate())

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding =
            StudentListsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding = binding, timeProvider = timeProvider)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(data = studentList[position])
    }

    override fun getItemCount(): Int = studentList.size



    companion object{
        const val DATE_FORMAT = "dd/MM/yyyy"
        private const val DATE_FORMAT_YEAR = "MM/dd/yyyy"
        private const val DATE_OF_THE_WEEK = "EEE"
        private const val DATE_FORMAT_TIME = "hh:mm a"

    }

}