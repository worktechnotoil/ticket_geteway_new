package com.technotoil.ticket.ui.signIn

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.BottomNavigation
import com.technotoil.ticket.repository.remote.RetrofitBuilder
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModel(): ViewModel() {

//
//    fun openMergeScreen(activity: Activity) {
//        //IntentHandler.openActivity(activity, MeargeActivity::class.java)
//        IntentHandler.openActivity(activity, BottomNavigation::class.java)
//    }

    fun mergeEmail(activity: Activity, params: MutableMap<String, String>, pBar: ProgressBar, btnLayout: RelativeLayout) {

        val call  = RetrofitBuilder.apiService.mergeEmailApi(params)

        call?.enqueue(object : Callback<EmailMergeResponse?> {
            override fun onResponse(
                call: Call<EmailMergeResponse?>,
                response: Response<EmailMergeResponse?>
            ) {
                pBar.visibility= View.INVISIBLE
                if (response.code() == 200) {
                    btnLayout.setEnabled(true)
                    val intent = Intent(activity, BottomNavigation::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    intent.putExtra("cell_phone", mobile)
//                    intent.putExtra("countryCode", countrypikker)
//                    intent.putExtra("login", "mobile")
                    activity.startActivity(intent)
                }else
                {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    btnLayout.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<EmailMergeResponse?>, t: Throwable) {
                pBar.visibility= View.INVISIBLE
            }
        })
    }

}