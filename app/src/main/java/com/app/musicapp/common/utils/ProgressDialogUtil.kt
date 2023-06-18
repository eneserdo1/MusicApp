package com.app.musicapp.common.utils

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.app.musicapp.R

object ProgressDialogUtil {
    private var progressDialog: Dialog? = null

    fun showProgress(context: Context) {
        if (progressDialog?.isShowing == true) {
            return
        }

        progressDialog = Dialog(context)

        val view = LayoutInflater.from(context).inflate(R.layout.layout_loading, null)
        progressDialog?.setContentView(view)
        progressDialog?.setCancelable(false)

        val window = progressDialog?.window
        val layoutParams = window?.attributes
        layoutParams?.width = ViewGroup.LayoutParams.WRAP_CONTENT
        layoutParams?.height = ViewGroup.LayoutParams.WRAP_CONTENT

        progressDialog?.show()
    }

    fun hideProgress() {
        progressDialog?.dismiss()
        progressDialog = null
    }
}
