package com.madonasyombua.learninghilt.di

import android.content.Context
import androidx.room.Room
import com.madonasyombua.learninghilt.data.local.StudentDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    private const val DATABASE_NAME : String = "studentdb"

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StudentDatabase =
        Room.databaseBuilder(context,
        StudentDatabase::class.java
        , DATABASE_NAME)
            .build()

    @Provides
    @Singleton
    fun provideUSerDao(database: StudentDatabase) = database.studentDao()
}