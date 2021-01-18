package com.madonasyombua.learninghilt.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.madonasyombua.learninghilt.data.StudentData
import kotlinx.coroutines.flow.Flow

/**
 * @author Madona Syombua
 * 2021 Learning Hilt
 */
//https://medium.com/androiddevelopers/room-coroutines-422b786dc4c5
// Suspend ensures generated code for the queries runs off the main thread
@Dao
interface StudentDao {

    @Query("SELECT *FROM studentList")
    fun loadAllStudentsLists(): Flow<List<StudentData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(students: StudentData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllStudents(students: List<StudentData>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateStudentList(students: StudentData)

    @Delete
    suspend fun deleteStudentList(students: StudentData)

    @Query("SELECT * FROM studentList where id = :id")
    fun loadAllStudentListById(id : Int): Flow<StudentData>
}