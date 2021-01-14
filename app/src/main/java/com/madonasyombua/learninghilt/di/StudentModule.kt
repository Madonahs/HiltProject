package com.madonasyombua.learninghilt.di

import com.madonasyombua.learninghilt.data.StudentRepository
import com.madonasyombua.learninghilt.data.StudentRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object StudentModule {
    @Provides
    fun provideStudentRepository(): StudentRepository = StudentRepositoryImpl()
}