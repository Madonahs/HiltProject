package com.madonasyombua.learninghilt

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.madonasyombua.learninghilt.data.local.StudentDatabase
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
abstract class LocalDbTest {
    private lateinit var db: StudentDatabase

    @Before
    fun `init db `(){
        db = Room.inMemoryDatabaseBuilder(getApplicationContext(), StudentDatabase::class.java)
                .allowMainThreadQueries()
                .build()
    }

    @After
    fun `close the db  `(){
        db.close()
    }

}