package com.technotoil.ticket.ui.signIn

import android.R
import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivitySignInBinding
import com.technotoil.ticket.repositories.MyPreferences
import com.technotoil.ticket.repositories.PrefConstants


class SignInActivity : BaseActivity<ActivitySignInBinding, SignInViewModel, Any?>() {
    var mobilePassed = "";
    override fun getLayout(): Int {
        return com.technotoil.ticket.R.layout.activity_sign_in
    }
    override fun getVmClass(): Class<SignInViewModel> {
        return SignInViewModel::class.java
    }

    var loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            val password: String = binding.edit.getText().toString().trim()

            if (!password.isEmpty()) {
                binding.showPassword.setVisibility(View.VISIBLE)

            } else {
                binding.hidePasswordOne.setVisibility(View.GONE)
            }
        }

        override fun afterTextChanged(editable: Editable) {

        }
    }


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.pBar.visibility = View.INVISIBLE
        binding.radioButton1.isChecked = true
        binding.edit.addTextChangedListener(loginTextWatcher)


        init()
        if (Build.VERSION.SDK_INT >= 21) {
            val colorStateList = ColorStateList(
                arrayOf(intArrayOf(-R.attr.state_checked), intArrayOf(R.attr.state_checked)),
                intArrayOf(
                    Color.parseColor("#D3D8DC"),     // disabled
                    Color.parseColor("#3399FF")  // enabled
                )
            )
            binding.radioButton1.setButtonTintList(colorStateList) // set the color tint list
            binding.radioButton1.invalidate() // Could not be necessary
        }

        if (Build.VERSION.SDK_INT >= 21) {
            val colorStateList = ColorStateList(
                arrayOf(intArrayOf(-R.attr.state_checked), intArrayOf(R.attr.state_checked)),
                intArrayOf(
                    Color.parseColor("#D3D8DC"),  // disabled
                    Color.parseColor("#3399FF") // enabled
                )
            )
            binding.radioButton2.setButtonTintList(colorStateList) // set the color tint list
            binding.radioButton2.invalidate() // Could not be necessary
        }

        binding.figure2.setOnClickListener {

            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("YOUR_WEB_APPLICATION_CLIENT_ID")
                .requestEmail()
                .build()

          val  mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
            val signInIntent = mGoogleSignInClient.signInIntent
            val RC_SIGN_IN = 200
            startActivityForResult(
                signInIntent, RC_SIGN_IN
            )
            }
        binding.skipImg.setOnClickListener {
            viewModel.openHomeScreen(this)
        }
        binding.login.setOnClickListener {
            val params: MutableMap<String, String> = HashMap()
            params["email_phone"] = binding.email.text.toString()
            params["password"] = binding.edit.text.toString()
            val mail: String = binding.email.getText().toString()
            val pass: String = binding.edit.getText().toString()

            if (mail.isEmpty()) {
                Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show()
            }
           else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()

            }
            else if (pass.isEmpty()) {
                Toast.makeText(this, "Enter Your Password", Toast.LENGTH_SHORT).show()
            }

            else {
                binding.pBar.visibility = View.VISIBLE
                binding.login.setEnabled(false)
                viewModel.signINEmailMethod(this, params, binding.pBar,binding.login)
            }
        }
    }

    private fun init() {


        binding.radioButton1.isChecked = true
        binding.radioButton1.setOnClickListener {
            binding.radioButton2.isChecked = false
            binding.mobiletext.setVisibility(View.GONE)
            binding.relativeLayout.setVisibility(View.GONE)
            binding.email.setVisibility(View.VISIBLE)
            binding.password.setVisibility(View.VISIBLE)
            binding.forgot.setVisibility(View.VISIBLE)


            binding.login.setOnClickListener {
                val params: MutableMap<String, String> = HashMap()
                params["email_phone"] = binding.email.text.toString()
                params["password"] = binding.edit.text.toString()
                val mail: String = binding.email.getText().toString()
                val pass: String = binding.edit.getText().toString()

                if (mail.isEmpty()) {
                    Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show()
                }

                else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()

                }
                else if (pass.isEmpty()) {
                    Toast.makeText(this, "Enter Your Password", Toast.LENGTH_SHORT).show()
                } else {

                    binding.login.setEnabled(false)

                    viewModel.signINEmailMethod(this, params,binding.pBar,binding.login)
                }
            }
        }

        binding.hidePasswordOne.setOnClickListener {
            binding.edit.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.showPassword.setVisibility(View.VISIBLE)
            binding.hidePasswordOne.setVisibility(View.GONE)

        }

        binding.showPassword.setOnClickListener {
            binding.edit.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.showPassword.setVisibility(View.GONE)
            binding.hidePasswordOne.setVisibility(View.VISIBLE)

        }

        binding.radioButton2.setOnClickListener {
            binding.radioButton1.isChecked = false
            binding.mobiletext.setVisibility(View.VISIBLE)
            binding.relativeLayout.setVisibility(View.VISIBLE)
            binding.email.setVisibility(View.GONE)
            binding.password.setVisibility(View.GONE)
            binding.forgot.setVisibility(View.GONE)
            binding.login.setOnClickListener {

                val params: MutableMap<String, String> = HashMap()
                params["cell_phone"] =
                    binding.countyCodePicker.selectedCountryCodeWithPlus.toString() + binding.mobile.text.toString()
                val countrypikker: String =binding.countyCodePicker.selectedCountryCodeWithPlus.toString()
                val countryMobile: String =binding.mobile.text.toString()
                val mobile: String = binding.mobile.getText().toString()
                if (mobile.isEmpty()) {
                    Toast.makeText(this, "mobile no is required", Toast.LENGTH_SHORT).show();
                } else {

                    binding.login.setEnabled(false)
                    binding.pBar.visibility = View.VISIBLE
                    viewModel.signINMobileMethod(this, params,countryMobile,countrypikker, binding.pBar,binding.login)
                }
            }
        }

        binding.forgot.setOnClickListener {
            viewModel.openForgotScreen(this)
        }

        binding.navigateToSignUp.setOnClickListener {
            viewModel.openSignUpScreen(this)
        }


    }


}
