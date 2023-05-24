package com.technotoil.ticket.ui.otpVerify

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityOtpverifyBinding


class OTPVerifyActivity : BaseActivity<ActivityOtpverifyBinding, OtpVrifyModel, Any?>() {

    var emailPassed = ""
    var logintype = ""
    var mobilePassed = ""
    var countryCode = ""

    override fun getLayout(): Int {
        return com.technotoil.ticket.R.layout.activity_otpverify
    }

    override fun getVmClass(): Class<OtpVrifyModel> {
        return OtpVrifyModel::class.java
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)

    }


    fun timer_resendOtp() {
        // binding.resend.visibility=View.INVISIBLE
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.resendtimer2.text = "" + millisUntilFinished / 1000 + "s"
            }

            override fun onFinish() {
                binding.resendtimer2.isEnabled = true
                binding.resend.text = "Resend OTP"
                binding.resendtimer1.text = ""
                binding.resend.setTextColor(Color.parseColor("#BD00B0FF"))
                binding.resendtimer2.text = ""
            }
        }.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.pBar.visibility = View.INVISIBLE
        emailPassed = intent.getStringExtra("email").toString()
        logintype = intent.getStringExtra("login").toString()
        binding.emailTextData.text = emailPassed
        mobilePassed = intent.getStringExtra("cell_phone").toString()
        countryCode = intent.getStringExtra("countryCode").toString()

        if (logintype=="mobile"){
            binding.emailTextData.text = countryCode.toString()+mobilePassed.toString()
            binding.mobileTextData.visibility = View.VISIBLE
        }else{
            binding.emailTextData.text = emailPassed
        }
        timer_resendOtp()
        init()
    }

    fun init() {
        configOtpEditText(
            binding.otpField1,
            binding.otpField2,
            binding.otpField3,
            binding.otpField4,
        )
        binding.ImageVie.setOnClickListener {
            finish()
        }
        binding.resend.setOnClickListener {
            if (logintype == "mobile") {

                 viewModel.mobileOtpAPI(this,countryCode.toString(),mobilePassed, binding.pBar,binding.resend)
            }else {
                viewModel.resendApi(this, emailPassed, binding.pBar,binding.resend)
            }
            binding.resendtimer2.isEnabled = false
            binding.resend.text = ""
            binding.resendtimer1.text = "You will receive OTP in"
            binding.resendtimer2.text = ""
            timer_resendOtp()
        }

        binding.btnLayout.setOnClickListener {
            it.hideKeyboard()
            var combinedOTP =
                binding.otpField1.text.toString() + binding.otpField2.text.toString() + binding.otpField3.text.toString() + binding.otpField4.text.toString()
            if (combinedOTP.isEmpty()) {
                Toast.makeText(this, "Please enter OTP", Toast.LENGTH_SHORT)
                    .show()
                binding.pBar.visibility = View.INVISIBLE
            } else {
                if (logintype == "mobile") {
                    binding.pBar.visibility = View.VISIBLE
                    viewModel.mobileOtpverify(this,countryCode.toString(),mobilePassed,combinedOTP.toString(),binding.pBar, binding.btnLayout)

                } else {
                    binding.btnLayout.setEnabled(false)
                    viewModel.otpVeriFyAPI(this, emailPassed, combinedOTP.toString(), binding.pBar,binding.btnLayout)
                    binding.pBar.visibility = View.VISIBLE
                }

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
