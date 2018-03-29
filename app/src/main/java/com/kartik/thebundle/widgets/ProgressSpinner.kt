package com.kartik.thebundle.widgets

import android.app.ProgressDialog
import android.content.Context

import com.kartik.thebundle.R

/**
 * Created by Kartik Kumar Gujarati on 3/28/18 1:58 PM
 * Copyright (c) 2018. All rights reserved.
 */

class ProgressSpinner(context: Context, message: String?) {

    val progressBar: ProgressDialog

    val isProgressDialogShowing: Boolean?
        get() = progressBar.isShowing

    init {

        progressBar = ProgressDialog(context, R.style.ProgressBarSpinnerThemeFullScreen)

        //show a spinner without message
        if (message != null && !message.isEmpty()) {
            progressBar.isIndeterminate = true
            progressBar.setMessage(message)
        }

        progressBar.setCancelable(false)
        progressBar.setProgressStyle(android.R.style.Widget_ProgressBar_Large)
    }

    fun showProgressDialog() {
        progressBar.show()
    }

    fun dismissProgressDialog() {
        progressBar.dismiss()
    }
}
