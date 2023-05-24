package com.technotoil.ticket.ui.signUp

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityCreateAccountBinding
import kotlin.collections.set

class CreateAccountActivity : BaseActivity<ActivityCreateAccountBinding, CreateAccountModel, Any?>() {
    var emailPassed = "";
    override fun getLayout(): Int {
        return R.layout.activity_create_account
    }
    override fun getVmClass(): Class<CreateAccountModel> {
        return CreateAccountModel::class.java
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
        binding.pBar.visibility= View.INVISIBLE
        emailPassed = intent.getStringExtra("email").toString()
        binding.email.setText(emailPassed)
        binding.edit.addTextChangedListener(loginTextWatcher)
        binding.editPass2.addTextChangedListener(loginTextWatcher)
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
        binding.createaccunt.setOnClickListener {

            val params: MutableMap<String, String> = HashMap()
            params["full_name"] = binding.fullname.text.toString()
            params["email"] = binding.email.text.toString()
            params["cell_phone"] =
                "+"+binding.countyCodePicker.selectedCountryCode.toString() + binding.mobile.text.toString()
            params["password"] = binding.editPass2.text.toString()
            params["confirm_password"] = binding.edit.text.toString()
            val name: String = binding.fullname.getText().toString()
            val mobileNumber: String = binding.mobile.getText().toString()
            val passw: String = binding.editPass2.getText().toString()
            val confpassw: String = binding.edit.getText().toString()

            if (name.isEmpty()) {
                Toast.makeText(this, "Full Name is Required!", Toast.LENGTH_SHORT).show()
            } else if (mobileNumber.isEmpty()) {
                Toast.makeText(this, "Mobile Number is Required!", Toast.LENGTH_SHORT).show()
            }
            else if (mobileNumber.length<10) {
                Toast.makeText(this, "Minimum Mobile length 10!", Toast.LENGTH_SHORT).show()
            }
            else if (passw.isEmpty()) {
                Toast.makeText(this, "Password is Required!", Toast.LENGTH_SHORT).show()
            }
            else if (confpassw.isEmpty()) {
                Toast.makeText(this, "Confirm Password is Required!", Toast.LENGTH_SHORT).show()
            }
            else if (passw!=confpassw) {
                Toast.makeText(this, "Password should be  Same!", Toast.LENGTH_SHORT).show()
            }
            else {
                binding.createaccunt.setEnabled(false)
                binding.pBar.visibility= View.VISIBLE
                viewModel.signupEmailAPI(this, params,binding.pBar,  binding.createaccunt )

            }
        }

        binding.ImageVie.setOnClickListener {
            finish()
        }
    }
}