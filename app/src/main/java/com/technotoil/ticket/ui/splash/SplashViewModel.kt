package com.technotoil.ticket.ui.splash

import android.app.Activity
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.BottomNavigation
import com.technotoil.ticket.repositories.MyPreferences
import com.technotoil.ticket.repositories.PrefConstants
import com.technotoil.ticket.ui.welcomeUser.WelcomeActivity
import com.technotoil.ticket.util.AppConstant
import com.technotoil.ticket.util.IntentHandler

class SplashViewModel() : ViewModel() {

    fun setHandler(activity: Activity) {
        Handler(Looper.getMainLooper()).postDelayed({
            val isUserLoggedIn= MyPreferences.getString(PrefConstants.USER_ID)

            if (isUserLoggedIn!=""){
                IntentHandler.openActivity(activity, BottomNavigation::class.java)
                activity.finish()

            }else{
                IntentHandler.openActivity(activity, WelcomeActivity::class.java)
                activity.finish()
            }

        }, AppConstant.DELAY_MILLISECONDS)
    }





}