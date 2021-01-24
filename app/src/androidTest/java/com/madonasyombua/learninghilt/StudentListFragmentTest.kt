package com.madonasyombua.learninghilt

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.madonasyombua.learninghilt.di.PersistenceModule
import com.madonasyombua.learninghilt.di.StudentModule
import com.madonasyombua.learninghilt.ui.fragment.StudentListsFragment
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Test
import org.junit.runner.RunWith

//https://developer.android.com/guide/fragments/test
//https://medium.com/pulselive/espresso-testing-with-hilt-and-mockwebserver-82f7bcf5a525

@UninstallModules(PersistenceModule::class,StudentModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class StudentListFragmentTest {

    @Test
    fun when_student_data_is_loaded_it_is_displayed_as_expected() {
        val scenario = launchFragmentInContainer<StudentListsFragment>()
        onView(withId(R.id.no_student_list)).check(matches(isDisplayed()))
    }
}