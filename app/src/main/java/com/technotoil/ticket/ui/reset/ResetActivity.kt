package com.technotoil.ticket.ui.reset

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityResetBinding

class ResetActivity : BaseActivity<ActivityResetBinding, ResetModel, Any?>() {

    override fun getLayout(): Int {
        return com.technotoil.ticket.R.layout.activity_reset
    }

    override fun getVmClass(): Class<ResetModel> {
        return ResetModel::class.java
    }

    var loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
        override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            val password: String = binding.edit.getText().toString().trim()
            val confirmpassword: String = binding.editPass2.getText().toString().trim()
            if (!password.isEmpty()) {
                binding.showPassword.setVisibility(View.VISIBLE)

            } else if (!confirmpassword.isEmpty()) {
                binding.showPassword.setVisibility(View.VISIBLE)

            }

            else {
                binding.hidePasswordOne.setVisibility(View.GONE)
            }
        }
        override fun afterTextChanged(editable: Editable) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.pBar.visibility = View.INVISIBLE

        init()

    }
    private fun init() {
        binding.edit.addTextChangedListener(loginTextWatcher)
        binding.editPass2.addTextChangedListener(loginTextWatcher)


        binding.hidePasswordOne1.setOnClickListener {
            binding.editPass2.transformationMethod = HideReturnsTransformationMethod.getInstance()
            binding.showPassword1.setVisibility(View.VISIBLE)
            binding.hidePasswordOne1.setVisibility(View.GONE)

        }

        binding.showPassword1.setOnClickListener {
            binding.editPass2.transformationMethod = PasswordTransformationMethod.getInstance()
            binding.showPassword1.setVisibility(View.GONE)
            binding.hidePasswordOne1.setVisibility(View.VISIBLE)

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





//        binding.showPassword1 .setOnClickListener {
//            binding.edit.transformationMethod = HideReturnsTransformationMethod.getInstance()
//            binding.showPassword.setVisibility(View.VISIBLE)
//            binding.hidePasswordOne.setVisibility(View.GONE)
//
//        }
//
//        binding.hidePasswordOne1 .setOnClickListener {
//            binding.edit.transformationMethod = PasswordTransformationMethod.getInstance()
//            binding.showPassword.setVisibility(View.GONE)
//            binding.hidePasswordOne.setVisibility(View.VISIBLE)
//
//        }
        binding.relativeLayout.setOnClickListener {


            val params: MutableMap<String, String> = HashMap()
            params["new_password"]=binding.editPass2.toString()
            params["confirm_password"] =binding.edit.toString()

            val newPass: String = binding.editPass2.getText().toString()
            val confirm: String = binding.edit.getText().toString()


            if (newPass.isEmpty()) {
                Toast.makeText(this, "Password is Required", Toast.LENGTH_SHORT).show()
            }

            else if (confirm.isEmpty()) {
                Toast.makeText(this, "Confirm Password is Required!", Toast.LENGTH_SHORT).show()
            }
            else if(newPass!=confirm) {
                Toast.makeText(this, "Confirm Password Should be Same", Toast.LENGTH_SHORT).show()
            }
            else {
                binding.pBar.visibility = View.VISIBLE
                binding.relativeLayout.setEnabled(false)
                viewModel.newPin(this, params, binding.pBar,binding.relativeLayout)
            }
        }

    }
}