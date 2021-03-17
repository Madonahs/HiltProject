package com.madonasyombua.learninghilt.di

import com.madonasyombua.learninghilt.util.SystemTimeProvider
import com.madonasyombua.learninghilt.util.TimeProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TimeModule {
    @Provides
    fun provideTimeProvider() : TimeProvider = SystemTimeProvider()
}