package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.mobileverifications

import android.content.Intent
import android.os.Bundle
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityMobileVarificationMainBinding

class MobileVarificationMainActivity : BaseActivity<ActivityMobileVarificationMainBinding, PhoneVerificationModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_mobile_varification_main
    }

    override fun getVmClass(): Class<PhoneVerificationModel> {
        return PhoneVerificationModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        clickEvent()



    }
    fun clickEvent(){
         binding.btnLayout.setOnClickListener {
             var number = binding.mobile.text.toString()
             var countryCode = binding.countyCodePicker.selectedCountryCodeWithPlus.toString()
             val intent = Intent(applicationContext, OtpVerificationActivity::class.java)
             intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
             intent.putExtra("cell_phone",number )
             intent.putExtra("countryCode",countryCode )
            startActivity(intent)
        }
    }
}