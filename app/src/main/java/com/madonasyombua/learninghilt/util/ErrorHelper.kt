package com.madonasyombua.learninghilt.util

import android.content.Context
import android.widget.Toast
import com.madonasyombua.learninghilt.R


class ErrorHelper {
    companion object {
        fun showError(context: Context, error: Throwable){
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_SHORT).show()
        }
    }
}