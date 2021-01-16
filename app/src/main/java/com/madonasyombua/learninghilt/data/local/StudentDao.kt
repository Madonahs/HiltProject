package com.madonasyombua.learninghilt.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.madonasyombua.learninghilt.data.StudentData
import kotlinx.coroutines.flow.Flow

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */

@Dao
interface StudentDao {

    @Query("SELECT *FROM studentList")
    fun loadAllStudentsLists(): Flow<List<StudentData>>

    @Insert
    suspend fun insertStudentList(students: StudentData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateStudentList(students: StudentData)

    @Delete
    suspend fun deleteStudentList(students: StudentData)

    @Query("SELECT * FROM studentList where id = :id")
    fun loadAllStudentListById(id : Int): LiveData<StudentData>
}