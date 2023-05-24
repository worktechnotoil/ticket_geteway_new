package com.technotoil.ticket.ui.getStarted


import android.app.Activity
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.BottomNavigation
import com.technotoil.ticket.ui.signIn.SignInActivity
import com.technotoil.ticket.ui.signUp.SignUpActivity
import com.technotoil.ticket.util.IntentHandler

class GetStartedViewModel() : ViewModel() {

    fun openSignInScreen(activity: Activity) {
        IntentHandler.openActivity(activity, SignInActivity::class.java)
    }

    fun openSignUpScreen(activity: Activity) {
        IntentHandler.openActivity(activity, SignUpActivity::class.java)
    }
    fun openHomeScreen(activity: Activity) {
        IntentHandler.openActivity(activity, BottomNavigation::class.java)
    }


}