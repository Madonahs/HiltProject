package com.madonasyombua.learninghilt.data.helpers

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.madonasyombua.learninghilt.R

enum class Permission{
    CAMERA,
    RECORD_AUDIO
}

class SendToSettingDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val permissionIntArray = arguments?.getIntArray(ARG_PERMISSIONS)
        val messages = if(permissionIntArray?.size ?: 0 > 1){
           R.string.permission
        }else{
            when(Permission.values()[permissionIntArray?.get(0) ?: 0]){
                Permission.CAMERA -> R.string.dialog_one
                else -> R.string.dialog_two
            }
        }
        val builder = MaterialAlertDialogBuilder(requireContext())
             builder.setTitle(R.string.dialog_setting_title)
             builder.setMessage(messages)
            .setPositiveButton(
                R.string.dialog_setting_positive_button_title
            ) { _, _ ->
                val intent = Intent()
                intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                val uri: Uri = Uri.fromParts(
                    "package",
                    requireContext().applicationContext.packageName, null
                )
                intent.data = uri
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
            .setNegativeButton(
                R.string.dialog_setting_negative_button_title
            ) { dialog, _ ->
                dialog.dismiss()
            }

        return builder.create()
    }

    companion object{
        private const val ARG_PERMISSIONS = "permissions"
        fun newInstance(permissions: List<Permission>): SendToSettingDialog{
            val permissionSetting = SendToSettingDialog()
            val args = Bundle()
            args.putIntArray(ARG_PERMISSIONS, permissions.map { it.ordinal }.toIntArray())
            permissionSetting.arguments = args
            return permissionSetting
        }
    }

}


