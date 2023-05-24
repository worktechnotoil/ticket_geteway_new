package com.technotoil.ticket.ui.forgotPassword

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.repository.remote.RetrofitBuilder
import com.technotoil.ticket.ui.signIn.SignInActivity
import models.ForgotEmailResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForgotPasswordViewModel() : ViewModel() {

//        fun openSignUpScreen(activity: Activity) {
//        IntentHandler.openActivity(activity, ResetActivity::class.java)
//    }
    fun forgotEmailMethod(activity: Activity, params: MutableMap<String, String>, pBar: ProgressBar,relativeLayout:RelativeLayout) {

        val call  = RetrofitBuilder.apiService.forgotEmailAPI(params)

        call?.enqueue(object : Callback<ForgotEmailResponse?> {
            override fun onResponse(
                call: Call<ForgotEmailResponse?>,
                response: Response<ForgotEmailResponse?>
            ) {
                if (response.code() == 200) {
                    relativeLayout.setEnabled(true)
                    pBar.visibility= View.INVISIBLE
                    val intent = Intent(activity, SignInActivity::class.java)
                    activity.startActivity(intent)
                }else
                {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    relativeLayout.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT).show()
                    pBar.visibility= View.INVISIBLE
                }
            }
            override fun onFailure(call: Call<ForgotEmailResponse?>, t: Throwable) {
                pBar.visibility= View.INVISIBLE
            }
        })
    }

}