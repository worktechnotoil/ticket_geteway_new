package com.technotoil.ticket.ui.reset

import android.app.Activity
import android.content.Intent
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.technotoil.ticket.repository.remote.RetrofitBuilder
import com.technotoil.ticket.ui.signIn.SignInActivity
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResetModel : ViewModel() {


    fun newPin(activity: Activity, params: MutableMap<String, String>, pBar: ProgressBar, relativeLayout: RelativeLayout) {

        val call  = RetrofitBuilder.apiService.newPinSetApi(params)

        call?.enqueue(object : Callback<JsonObject?> {
            override fun onResponse(
                call: Call<JsonObject?>,
                response: Response<JsonObject?>
            ) {
                pBar.visibility= View.INVISIBLE
                if (response.code() == 200) {
                    relativeLayout.setEnabled(true)
                    val intent = Intent(activity, SignInActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    activity.startActivity(intent)
                }else
                {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    relativeLayout.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT).show()
//                    val intent = Intent(activity, SignInActivity::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    activity.startActivity(intent)
                }
            }
            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                pBar.visibility= View.INVISIBLE
            }
        })
    }


}