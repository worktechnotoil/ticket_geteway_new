package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment

import android.content.Intent
import android.os.Bundle
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityPaymentSuccessBinding

class PaymentSuccessActivity : BaseActivity<ActivityPaymentSuccessBinding, PaymentSuccessModel, Any?>() {


    override fun getLayout(): Int {
        return R.layout.activity_payment_success
    }

    override fun getVmClass(): Class<PaymentSuccessModel> {
        return PaymentSuccessModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        click_event()

    }
    fun  click_event(){
        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, PaymentFailedActivity::class.java)
            startActivity(intent)
        }

    }
}