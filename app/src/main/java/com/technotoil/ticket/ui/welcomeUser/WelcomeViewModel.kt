package com.technotoil.ticket.ui.welcomeUser


import android.app.Activity
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.ui.getStarted.GetStartedActivity
import com.technotoil.ticket.util.IntentHandler

class WelcomeViewModel() : ViewModel() {

    fun openGetStartedActivity(activity: Activity) {
        IntentHandler.openActivity(activity, GetStartedActivity::class.java)
        activity.finish()


    }

}