package com.technotoil.ticket.ui.signUp

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.BottomNavigation
import com.technotoil.ticket.repository.remote.RetrofitBuilder
import com.technotoil.ticket.ui.otpVerify.OTPVerifyActivity
import com.technotoil.ticket.ui.signIn.SignInActivity
import com.technotoil.ticket.util.IntentHandler
import models.EmailSignupModel
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpViewModel() : ViewModel() {

    fun openSignInScreen(activity: Activity) {
        IntentHandler.openActivity(activity, SignInActivity::class.java)
    }
    fun openHomeScreen(activity: Activity) {
        IntentHandler.openActivity(activity, BottomNavigation::class.java)
    }

    fun signupEmailAPI(activity: Activity, email: String, pBar: ProgressBar,relative:RelativeLayout) {
        val params: MutableMap<String, String> = HashMap()
        params["email"] = email

        val call = RetrofitBuilder.apiService.SignUpEmail(params)

        call?.enqueue(object : Callback<EmailSignupModel?> {
            override fun onResponse(
                call: Call<EmailSignupModel?>,
                response: Response<EmailSignupModel?>
            ) {
                pBar.visibility = View.INVISIBLE
                if (response.code() == 200) {
                    relative.setEnabled(true)
                    val intent = Intent(activity, OTPVerifyActivity::class.java)
                    intent.putExtra("email", email)
                    intent.putExtra("login", "email")
                    activity.startActivity(intent)
                } else {

                    val jObjError = JSONObject(response.errorBody()!!.string())
                    relative.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<EmailSignupModel?>, t: Throwable) {
                pBar.visibility = View.INVISIBLE
            }
        })
    }


}