package com.madonasyombua.learninghilt.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.madonasyombua.learninghilt.R
import com.madonasyombua.learninghilt.di.StudentModule
import com.madonasyombua.learninghilt.launchFragmentInHiltContainer
import com.madonasyombua.learninghilt.ui.fragment.StudentListsFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock

//https://developer.android.com/guide/fragments/test
//https://medium.com/pulselive/espresso-testing-with-hilt-and-mockwebserver-82f7bcf5a525
//https://developer.android.com/reference/androidx/test/espresso/contrib/RecyclerViewActions

@UninstallModules(StudentModule::class)
@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class StudentListFragmentTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)


    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun displayStudentListSucceeded(){
        launchFragmentInHiltContainer<StudentListsFragment> {

        }

        onView(withId(R.id.student_list_recyler)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun displayStudentListFailed(){
        launchFragmentInHiltContainer<StudentListsFragment> {
            studentListAdapter.studentList = emptyList()
        }

    }

    @ExperimentalCoroutinesApi
    @Test
    fun whenButtonClickedNavigateToAnotherScreen(){
        val navController = mock(NavController::class.java)
        launchFragmentInHiltContainer<StudentListsFragment> {
            Navigation.setViewNavController(requireView(), navController)

        }

        onView(withId(R.id.button)).check(matches(isClickable()))

       // Mockito.verify(navController).navigate(ListOfStudentFragment.)
    }
}