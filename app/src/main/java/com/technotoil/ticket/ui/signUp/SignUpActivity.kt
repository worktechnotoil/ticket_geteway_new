package com.technotoil.ticket.ui.signUp

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivitySignUpBinding


class SignUpActivity : BaseActivity<ActivitySignUpBinding, SignUpViewModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_sign_up
    }

    override fun getVmClass(): Class<SignUpViewModel> {
        return SignUpViewModel::class.java
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.pBar.visibility= View.INVISIBLE
        init()
    }

    private fun init() {

        binding.navigateToSignIn.setOnClickListener {

            viewModel.openSignInScreen(this)
        }
        binding.skipImg.setOnClickListener {
            viewModel.openHomeScreen(this)
        }


        binding.relative.setOnClickListener {
            it.hideKeyboard()
            val mail: String = binding.emailaddress.getText().toString()


            if (mail.isEmpty()) {
                Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show()
            }
            else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()

            }
            else {
                binding.relative.setEnabled(false);
                viewModel.signupEmailAPI(this, binding.emailaddress.text.toString(),binding.pBar,binding.relative)
                binding.pBar.visibility= View.VISIBLE
            }
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


    }





}


