package com.technotoil.ticket.ui.forgotPassword

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : BaseActivity<ActivityForgotPasswordBinding, ForgotPasswordViewModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_forgot_password
    }

    override fun getVmClass(): Class<ForgotPasswordViewModel> {
        return ForgotPasswordViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.pBar.visibility= View.INVISIBLE
        init()
    }

    private fun init() {
    binding.relativeLayout.setOnClickListener {
        binding.pBar.visibility= View.VISIBLE
        val params: MutableMap<String, String> = HashMap()
        params["email"] = binding.emailText.text.toString()
        val mail: String = binding.emailText.getText().toString()
        if (mail.isEmpty()) {
            binding.pBar.visibility= View.INVISIBLE
            Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show()
        }  else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
            binding.pBar.visibility= View.INVISIBLE
            Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()

        }
        else {
            binding.relativeLayout.setEnabled(false)

            viewModel.forgotEmailMethod(this, params,binding.pBar,binding.relativeLayout)
        }
    }
        binding.ImageVie.setOnClickListener{
            finish()
        }
    }

}