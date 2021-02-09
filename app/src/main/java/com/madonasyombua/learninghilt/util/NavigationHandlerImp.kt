package com.madonasyombua.learninghilt.util

import android.app.Activity
import android.content.Context
import androidx.navigation.NavController
import com.madonasyombua.learninghilt.R
import com.madonasyombua.learninghilt.data.StudentData
import com.madonasyombua.learninghilt.data.local.StudentDao
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

class NavigationHandlerImp @Inject constructor(
    @ApplicationContext private val appContext: Context,
    private val recentInvitationDao: StudentDao,
    private val applicationScope: CoroutineScope,

    ) : NavigationHandler {
        /*
            Logs in with the invitation code provided.  Checks if the user has already accepted the terms and conditions and granted permissions.
            If so, calls showLobby(). If not, launches the OnboardingFragment.
         */
        override suspend fun launchWithInviteCode(
            invitationCode: String,
            navController: NavController,
            currentActivity: Activity
        ) {
           /* val onboardingInfo = loginRepository.loginAndVerifyTerms(invitationCode)
            val missingPermission = streem.getMissingPermissions(appContext)
            if (onboardingInfo.termsAccepted && missingPermission.isEmpty()) {
                Timber.d("Terms accepted and permissions granted, starting Streem lobby")
                showLobby(onboardingInfo.invitation, navController, currentActivity)
            } else {
                Timber.d("Terms not accepted or permissions not granted, navigating to OnboardingFragment")
                navController.navigate(R.id.onboarding_fragment, bundleFactory.createBundle().apply {
                    putSerializable(OnboardingViewModel.ONBOARDING_INFO_KEY, onboardingInfo)
                })*/
            }

    override fun showLobby(
        recentInvitation: StudentData,
        navController: NavController,
        currentActivity: Activity
    ) {
        TODO("Not yet implemented")
    }
}
           /* Timber.d("Launching lobby")
            streem.loginAndShowInvitationDialog(
                invitationCode = recentInvitation.invitationCode,
                isExpert = false,
                currentActivity = currentActivity,
                streemInvitationHandler = {
                    Timber.d("Got invitation response: $it")
                },
                invitationDialogResponseHandler = { invitationDialogResponse ->
                    if (invitationDialogResponse is Streem.InvitationDialogResponse.Accepted) {
                        Timber.d("Got Accepted invitationDialogResponse, updating callStartedAt")
                        applicationScope.launch {
                            recentInvitation.callStartedAt = timeProvider.getCurrentDate()
                            recentInvitationDao.updateRecentInvitation(recentInvitation)
                            Timber.d("Invitation callStartedAt has been updated to ${recentInvitation.callStartedAt}")
                        }
                        navController.popBackStack(R.id.recent_fragment, false)
                    } else {
                        Timber.d("Streem call was not started, callStartedAt will not be updated")
                    }
                })*/


