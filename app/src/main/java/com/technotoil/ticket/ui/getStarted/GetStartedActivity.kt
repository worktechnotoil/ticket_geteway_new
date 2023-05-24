package com.technotoil.ticket.ui.getStarted

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityGetStartedBinding

class GetStartedActivity : BaseActivity<ActivityGetStartedBinding, GetStartedViewModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_get_started
    }

    override fun getVmClass(): Class<GetStartedViewModel> {
        return GetStartedViewModel::class.java
    }
    fun View.hideKeyboard() {
        val inputManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(windowToken, 0)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        init()

    }

    private fun init() {
        binding.signInButton.setOnClickListener {
            viewModel.openSignInScreen(this)
            it.hideKeyboard()
        }
        binding.signUpButton.setOnClickListener {
            it.hideKeyboard()
            viewModel.openSignUpScreen(this)
        }

        binding.skipImg.setOnClickListener {
            it.hideKeyboard()
            viewModel.openHomeScreen(this)
        }
    }

}