package com.madonasyombua.learninghilt.ui.fragment

import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import com.madonasyombua.learninghilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = requireActivity().intent
        when (intent?.action) {
            ACTION_VIEW -> handleViewIntent(intent)
        }
    }

    private fun handleViewIntent(intent: Intent) {
        val data = intent.data ?: return

        isInvitationUrl(data.toString())?.let {
            handleDeepLinkInvitationUri(data)
        }
    }

    private fun handleDeepLinkInvitationUri(invitationUri: Uri) {

    }

    //If [text] is an invitation URL, then returns the invitation code from the URL.
    private fun isInvitationUrl(text: String): String? {
        return if (INVITATION_URL_REGEX.matches(text)) {
            text.substring(text.lastIndexOf(URL_QUERY_NAME_VALUE_SEPARATOR) + 1)
        } else {
            null
        }
    }

        override fun onAttach(context: Context) {
            super.onAttach(context)
            requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        override fun onDetach() {
            super.onDetach()
            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        companion object {
            private const val INVITATION_CODE_LENGTH = 9
            private const val URL_QUERY_NAME_VALUE_SEPARATOR = "="
            private val INVITATION_URL_REGEX =
                "^http.+invite$URL_QUERY_NAME_VALUE_SEPARATOR\\d{$INVITATION_CODE_LENGTH}$".toRegex()
        }
}



