package com.madonasyombua.learninghilt.util

import android.app.Activity
import androidx.navigation.NavController
import com.madonasyombua.learninghilt.data.StudentData

interface NavigationHandler {
    suspend fun launchWithInviteCode(
        invitationCode: String,
        navController: NavController,
        currentActivity: Activity
    )

    fun showLobby(
        recentInvitation: StudentData,
        navController: NavController,
        currentActivity: Activity
    )
}