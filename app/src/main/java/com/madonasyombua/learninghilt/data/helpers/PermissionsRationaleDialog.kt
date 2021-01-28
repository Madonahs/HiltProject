package com.madonasyombua.learninghilt.data.helpers

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.lang.ClassCastException

class PermissionsRationaleDialog : DialogFragment(){

    private lateinit var listener : PermissionListener
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val missingPermissions = arguments?.getStringArray(ARG_PERMISSIONS) ?: arrayOf()
        return AlertDialog.Builder(requireContext())
            .setTitle("Learning hilt would love to access Microphone and Camera")
            .setMessage("This App uses these permissions to do abc")
            .setPositiveButton("ok"){_,_ ->
                dismiss()
                listener.onRationaleAllow(missingPermissions)
            }
            .setNegativeButton("Cancel"){_,_->
                dismiss()
                listener.onRationaleDontAllow(
                    missingPermissions
                )
            }.create()

    }

    companion object{
        const val ARG_PERMISSIONS = "permissions"
        fun newInstance(permissions: List<String>): PermissionsRationaleDialog{
            return PermissionsRationaleDialog().apply {
                arguments = Bundle().apply {
                    putStringArray(ARG_PERMISSIONS, permissions.toTypedArray())
                }
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            listener = parentFragment as PermissionListener
        }catch (e: ClassCastException){
            throw ClassCastException(
                (parentFragment.toString() + "must implement Permission Listener")
            )
        }
    }

    //create an interface to be extended in a parent class to bring the permissions dialog functions
    //to the class you want.
    interface PermissionListener{
        fun onRationaleDontAllow(permissions: Array<String>)
        fun onRationaleAllow(permissions: Array<String>)
    }

}