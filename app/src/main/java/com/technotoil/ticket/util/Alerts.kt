package com.technotoil.ticket.util

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object Alerts {

    fun show(context: Context?, msg: String) {
        if (context != null && msg.isNotEmpty()) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }

    fun show(container: View?, msg: String?) {
        Snackbar.make(container!!, msg!!, Snackbar.LENGTH_LONG).show()
    }

    fun withFeedback(
        container: View?, msg: String?, btnTitle: String?, onClickListener: View.OnClickListener?
    ) {
        val snackbar = Snackbar.make(container!!, msg!!, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction(btnTitle, onClickListener)
        snackbar.show()
    }
}