package com.madonasyombua.learninghilt.di

import com.madonasyombua.learninghilt.data.FakeDataRepository
import com.madonasyombua.learninghilt.data.StudentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(components = [SingletonComponent::class],
replaces = [StudentModule::class])
object FakeStudentModule {

    @Singleton
    @Provides
    fun provideStudentRepository(): StudentRepository = FakeDataRepository()
}