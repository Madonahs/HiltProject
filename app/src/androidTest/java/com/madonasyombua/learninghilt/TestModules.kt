package com.madonasyombua.learninghilt

import android.content.Context
import androidx.room.Room
import com.madonasyombua.learninghilt.data.StudentRepository
import com.madonasyombua.learninghilt.data.local.StudentDao
import com.madonasyombua.learninghilt.data.local.StudentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestModules {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StudentDatabase =
        Room.inMemoryDatabaseBuilder(
            context,
            StudentDatabase::class.java
        ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideUSerDao(database: StudentDatabase) = database.studentDao()

    @Provides
    fun provideStudentRepository(dao: StudentDao): StudentRepository =
        FakeStudentRepositoryImpl(dao = dao)
}