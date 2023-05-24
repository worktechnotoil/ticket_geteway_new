package com.technotoil.ticket.ui.signIn

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.technotoil.ticket.BottomNavigation
import com.technotoil.ticket.repositories.MyPreferences
import com.technotoil.ticket.repositories.PrefConstants
import com.technotoil.ticket.repository.remote.RetrofitBuilder
import com.technotoil.ticket.ui.forgotPassword.ForgotPasswordActivity
import com.technotoil.ticket.ui.otpVerify.OTPVerifyActivity
import com.technotoil.ticket.ui.signUp.SignUpActivity
import com.technotoil.ticket.util.IntentHandler
import models.SignInResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInViewModel() : ViewModel() {

    fun openSignUpScreen(activity: Activity) {
        IntentHandler.openActivity(activity, SignUpActivity::class.java)
    }
    fun openHomeScreen(activity: Activity) {
        IntentHandler.openActivity(activity, BottomNavigation::class.java)
    }

    fun openForgotScreen(activity: Activity) {
        IntentHandler.openActivity(activity, ForgotPasswordActivity::class.java)
    }



    fun signINEmailMethod(activity: Activity, params: MutableMap<String, String> , pBar: ProgressBar,login:RelativeLayout) {

        val call  = RetrofitBuilder.apiService.signINEmailAPI(params)

        call?.enqueue(object : Callback<SignInResponse?> {
            override fun onResponse(
                call: Call<SignInResponse?>,
                response: Response<SignInResponse?>
            ) {
                pBar.visibility= View.INVISIBLE
                if (response.code() == 200) {

                       var ids=response.body()?.data?.id
                        //MyPreferences.put(PrefConstants.USER_ID,ids)
                    MyPreferences.putString(
                    PrefConstants.USER_ID,
                        response.body()?.data?.id.toString()
                    )

                    login.setEnabled(true)

                    val intent = Intent(activity, BottomNavigation::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    activity.startActivity(intent)
                }else
                {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    login.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<SignInResponse?>, t: Throwable) {
                pBar.visibility= View.INVISIBLE
            }
        })
    }

    fun signINMobileMethod(activity: Activity, params: MutableMap<String, String> ,mobile: String, countrypikker:String, pBar: ProgressBar,login:RelativeLayout) {

        val call  = RetrofitBuilder.apiService.signINMobileAPI(params)

        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(
                call: Call<JsonObject?>,
                response: Response<JsonObject?>
            ) {
                pBar.visibility= View.INVISIBLE
                if (response.code() == 200) {
                    login.setEnabled(true)
                    val intent = Intent(activity, OTPVerifyActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    intent.putExtra("cell_phone", mobile)
                    intent.putExtra("countryCode", countrypikker)
                    intent.putExtra("login", "mobile")
                    activity.startActivity(intent)
                }else
                {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    login.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                pBar.visibility= View.INVISIBLE
            }
        })
    }

}