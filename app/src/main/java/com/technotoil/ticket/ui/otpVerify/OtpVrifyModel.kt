package com.technotoil.ticket.ui.otpVerify

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.technotoil.ticket.R
import com.technotoil.ticket.repository.remote.RetrofitBuilder
import com.technotoil.ticket.ui.signIn.LoginActivity
import com.technotoil.ticket.ui.signIn.MobileOtpResponse
import com.technotoil.ticket.ui.signUp.CreateAccountActivity
import models.EmailSignupModel
import models.VeriFyOtpResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable


class OtpVrifyModel() : ViewModel() {
 // fun openSignUpScreen(activity: Activity) {
//        IntentHandler.openActivity(activity, CreateAccountActivity::class.java)
//    }
    fun otpVeriFyAPI(activity: Activity, email: String, otp: String, pBar: ProgressBar,btnLayout:RelativeLayout) {
        val params: MutableMap<String, String> = HashMap()
        params["email"] = email
        params["otp"] = otp
        val call = RetrofitBuilder.apiService.VerifyOtp(params)

        call?.enqueue(object : Callback<VeriFyOtpResponse?> {
            override fun onResponse(
                call: Call<VeriFyOtpResponse?>,
                response: Response<VeriFyOtpResponse?>
            ) {
                pBar.visibility = View.INVISIBLE
                if (response.code() == 200) {
                    btnLayout.setEnabled(true)
                    // showMessageBox()
//                    val intent = Intent(activity, CreateAccountActivity::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    intent.putExtra("email", email)
//                    activity.startActivity(intent)
                    showMessageBox(activity, email)
                } else {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    btnLayout.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<VeriFyOtpResponse?>, t: Throwable) {
                pBar.visibility = View.INVISIBLE
            }
        })
    }


    fun mobileOtpAPI(activity: Activity,countryCode: String, mobile: String, pBar: ProgressBar,resend:TextView) {
        val params: MutableMap<String, String> = HashMap()
        params["cell_phone"] = countryCode.toString()+mobile.toString()
        val call = RetrofitBuilder.apiService.mobileOtpVerifyAPI(params)

        call?.enqueue(object : Callback<MobileOtpVerifyResponse?> {
            override fun onResponse(
                call: Call<MobileOtpVerifyResponse?>,
                response: Response<MobileOtpVerifyResponse?>
            ) {
                pBar.visibility = View.INVISIBLE

                if (response.code() == 200) {
                    resend.setEnabled(true)
                    Toast.makeText(activity, response.message(), Toast.LENGTH_SHORT)
                } else {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    resend.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
            override fun onFailure(call: Call<MobileOtpVerifyResponse?>, t: Throwable) {
                pBar.visibility = View.INVISIBLE
            }
        })
    }

    fun mobileOtpverify(activity: Activity,countryCode:String, mobile: String, otp: String, pBar: ProgressBar,btnLayout:RelativeLayout) {
        val params: MutableMap<String, String> = HashMap()
        params["cell_phone"] =countryCode.toString()+mobile.toString()
        params["otp"] = otp
        val call = RetrofitBuilder.apiService.mobileOtpVerify(params)

        call?.enqueue(object : Callback<MobileOtpResponse?> {
            override fun onResponse(
                call: Call<MobileOtpResponse?>,
                response: Response<MobileOtpResponse?>
            ) {
                pBar.visibility = View.INVISIBLE
                if (response.code() == 200) {
                    btnLayout.setEnabled(true)
                    val intent = Intent(activity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    intent.putExtra("phone", mobile)
                    intent.putExtra("loginData", "call")
                    intent.putExtra("ARRAYLIST", response.body()?.data as Serializable)
                    activity.startActivity(intent)

                } else {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    btnLayout.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }

            override fun onFailure(call: Call<MobileOtpResponse?>, t: Throwable) {
                pBar.visibility = View.INVISIBLE
            }
        })
    }


    fun resendApi(activity: Activity, email: String, pBar: ProgressBar,resend:TextView) {
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
                    resend.setEnabled(true)


                    // showMessageBox()
//                    val intent = Intent(activity, CreateAccountActivity::class.java)
//                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//                    intent.putExtra("email", email)
//                    activity.startActivity(intent)
                    //showMessageBox(activity,email)


                } else {
                    val jObjError = JSONObject(response.errorBody()!!.string())
                    resend.setEnabled(true)
                    Toast.makeText(activity, jObjError["message"].toString(), Toast.LENGTH_SHORT)
                        .show()
                    pBar.visibility = View.INVISIBLE
                }
            }

            override fun onFailure(call: Call<EmailSignupModel?>, t: Throwable) {
                pBar.visibility = View.INVISIBLE
            }
        })
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)

    }
    fun showMessageBox(activity: Activity, email: String) {
        val messageBoxView = LayoutInflater.from(activity).inflate(R.layout.message_box, null)
        val messageBoxBuilder = AlertDialog.Builder(activity).setView(messageBoxView)
        val messageBoxInstance = messageBoxBuilder.show()
        val spinner = messageBoxView.findViewById<TextView>(R.id.supabutton)

//        if (email==null) {
//
//            messageBoxInstance.getButton(AlertDialog.BUTTON1).setEnabled(false);
//        }

        spinner.setOnClickListener {
            it.hideKeyboard()


            messageBoxInstance.show()
            val intent = Intent(activity, CreateAccountActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("email", email)
            activity.startActivity(intent)
            messageBoxInstance.dismiss()


        }

    }

}

