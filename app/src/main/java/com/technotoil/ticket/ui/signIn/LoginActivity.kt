package com.technotoil.ticket.ui.signIn

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityLoginBinding


class LoginActivity : BaseActivity<ActivityLoginBinding, LoginModel, MobileOTPResponseData>(){
    var mobilePassed = ""
    lateinit var adapterq: LoginDataAdapter


    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun getVmClass(): Class<LoginModel> {
        return LoginModel::class.java
    }
    var emaildata =""


    @RequiresApi(33)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val i = intent
        var list = i.getSerializableExtra("ARRAYLIST") as List<MobileOTPResponseData?>?
        mobilePassed = intent.getStringExtra("phone").toString()
        binding.mobileNonEdit.setText(mobilePassed)
        val recyclerview = findViewById<RecyclerView>(R.id.rv_list)
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapterq = LoginDataAdapter(list as ArrayList<MobileOTPResponseData>)
        recyclerview.adapter = adapterq
        binding.pBar.visibility = View.INVISIBLE
        emaildata=list[0].email.toString()
        init()
        println(emaildata)
    }

        fun init() {
            binding.ImageVie.setOnClickListener {
                binding.pBar.visibility = View.VISIBLE
                finish()
            }

//            binding.btnLayout.setOnClickListener{
//               // viewModel.openMergeScreen(this)
//                viewModel.mergeEmail(this, params,countryMobile,countrypikker, binding.pBar,binding.login)
//
//            }

            binding.btnLayout.setOnClickListener {
                val params: MutableMap<String, String> = HashMap()
                val mail: String = emaildata.toString()
                params["email"] = mail

                if (mail.isEmpty()) {
                    Toast.makeText(this, "Enter Your Email", Toast.LENGTH_SHORT).show()
                } else {
                    binding.pBar.visibility = View.VISIBLE
                    binding.login.setEnabled(false)
                    viewModel.mergeEmail(this, params,binding.pBar,binding.btnLayout)
                }
            }

        }



}


