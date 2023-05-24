package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.mobileverifications

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityOtpVerificationBinding

class OtpVerificationActivity : BaseActivity<ActivityOtpVerificationBinding, OtpModel, Any?>() {

    var mobilePassed = ""
    var countryCode = ""


    override fun getLayout(): Int {
        return R.layout.activity_otp_verification
    }

    override fun getVmClass(): Class<OtpModel> {
        return OtpModel::class.java

    }

    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)

    }


    fun timer_resendOtp() {
        // binding.resend.visibility=View.INVISIBLE
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.resendtimer1.text = "Resend SMS in " + millisUntilFinished / 1000 + " sec "
            }

            override fun onFinish() {
                //binding.resendtimer2.isEnabled = true
                binding.resend.text = "Resend OTP"
                binding.resendtimer1.text = ""
//                binding.resend.setTextColor(Color.parseColor("#BD00B0FF"))
                binding.resendtimer1.text = ""
            }
        }.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        mobilePassed = intent.getStringExtra("cell_phone").toString()
        //binding.mobilenumber.text
        countryCode = intent.getStringExtra("countryCode").toString()
    // binding.mobilenumber.text
        var data=countryCode+mobilePassed
        binding.mobilenumber.setText(data)
        //data=binding.mobilenumber.text.toString()
        timer_resendOtp()
        init()
    }

    fun init() {
        configOtpEditText(
            binding.otpField1,
            binding.otpField2,
            binding.otpField3,
            binding.otpField4,
            binding.otpField5,
            binding.otpField6,
        )
        binding.ImageVie.setOnClickListener {
            finish()
        }
        binding.resend.setOnClickListener {

          //  binding.resendtimer2.isEnabled = false
            binding.resend.text = ""
            binding.resendtimer1.text = ""
          ///  binding.resendtimer2.text = ""
            timer_resendOtp()
        }

        binding.btnLayout.setOnClickListener {
            it.hideKeyboard()
            var combinedOTP =
                binding.otpField1.text.toString() + binding.otpField2.text.toString() + binding.otpField3.text.toString() + binding.otpField4.text.toString()+binding.otpField5.text.toString()+binding.otpField6.text.toString()
            if (combinedOTP.isEmpty()) {
                Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT)
                    .show()
                //binding.pBar.visibility = View.INVISIBLE
            } else {


            }

        }

    }


    fun configOtpEditText(vararg etList: EditText) {
        val afterTextChanged = { index: Int, e: Editable? ->
            val view = etList[index]
            val text = e.toString()

            when (view.id) {

                etList[0].id -> {
                    if (text.isNotEmpty()) etList[index + 1].requestFocus()
                }

                // las text changed
                etList[etList.size - 1].id -> {
                    if (text.isEmpty()) etList[index - 1].requestFocus()
                }

                // middle text changes
                else -> {
                    if (text.isNotEmpty()) etList[index + 1].requestFocus()
                    else etList[index - 1].requestFocus()
                }
            }
            false
        }
        etList.forEachIndexed { index, editText ->
            editText.doAfterTextChanged { afterTextChanged(index, it) }
        }
    }
}