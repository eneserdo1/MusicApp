package com.app.musicapp.common.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.app.musicapp.R

class Alert {
    companion object {
        lateinit var errorDialog: AlertDialog
        lateinit var successDialog: AlertDialog
        lateinit var pagingErrorDialog: AlertDialog

        fun Context.showErrorPopup(positiveListener: () -> Unit, negativeListener: () -> Unit) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.alert_message_title))
            builder.setMessage(getString(R.string.alert_message_description))
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton(getString(R.string.alert_message_positive_button_title)) { _, _ ->
                positiveListener.invoke()
            }
            builder.setNegativeButton(getString(R.string.alert_message_negative_button_title)) { _, _ ->
                negativeListener.invoke()
            }

            errorDialog = builder.create()
            errorDialog.setCancelable(false)
            errorDialog.show()
        }

        fun Context.showPagingErrorPopup(positiveListener: () -> Unit) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.alert_message_title))
            builder.setMessage(getString(R.string.alert_message_description))
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setNegativeButton(getString(R.string.ok)) { _, _ ->
                positiveListener.invoke()
            }

            pagingErrorDialog = builder.create()
            pagingErrorDialog.setCancelable(false)
            pagingErrorDialog.show()
        }

        fun Context.showSuccessPopup(positiveListener: () -> Unit) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.deleted_successfully_title))
            builder.setMessage(getString(R.string.deleted_successfully_message))
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            builder.setPositiveButton(getString(R.string.ok)) { _, _ ->
                positiveListener.invoke()
            }
            successDialog = builder.create()
            successDialog.setCancelable(true)
            successDialog.show()
        }
    }
}