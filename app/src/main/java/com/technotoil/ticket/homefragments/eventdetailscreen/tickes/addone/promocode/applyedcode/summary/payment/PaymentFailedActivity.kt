package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment

import android.content.Intent
import android.os.Bundle
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityPaymentFailedBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.mobileverifications.MobileVarificationMainActivity

class PaymentFailedActivity : BaseActivity<ActivityPaymentFailedBinding, PaymentFailedModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_payment_failed
    }

    override fun getVmClass(): Class<PaymentFailedModel> {
        return PaymentFailedModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, MobileVarificationMainActivity::class.java)
            startActivity(intent)
        }


    }

}