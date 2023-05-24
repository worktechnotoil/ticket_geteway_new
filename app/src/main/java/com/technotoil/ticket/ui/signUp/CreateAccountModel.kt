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
import models.CreateAccountResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CreateAccountModel() : ViewModel() {

//    fun openLoginActivity(activity: Activity) {
//        IntentHandler.openActivity(activity, LoginActivity::class.java)
//    }
    fun signupEmailAPI(activity: Activity, params: MutableMap<String, String>,pBar: ProgressBar,createaccunt:RelativeLayout) {

        val call  = RetrofitBuilder.apiService.createAccountAPI(params)

        call?.enqueue(object : Callback<CreateAccountResponse?> {
            override fun onResponse(
                call: Call<CreateAccountResponse?>,
                response: Response<CreateAccountResponse?>
            ) {
                pBar.visibility= View.INVISIBLE
                if (response.code() == 200) {
                    createaccunt.setEnabled(true)

                    val intent = Intent(activity, BottomNavigation::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    activity.startActivity(intent)
                }else
                {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    createaccunt.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<CreateAccountResponse?>, t: Throwable) {
                pBar.visibility= View.INVISIBLE
            }
        })
    }

}