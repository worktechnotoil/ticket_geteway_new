package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.addwalletamount

import android.content.Intent
import android.os.Bundle
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityWalletAddSuccessBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.PaymentMethodMainActivity

class WalletAddSuccessActivity : BaseActivity<ActivityWalletAddSuccessBinding, WalletAddSuccessModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_wallet_add_success
    }

    override fun getVmClass(): Class<WalletAddSuccessModel> {
        return WalletAddSuccessModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        clickEvent()

    }
fun  clickEvent(){
    binding.okay.setOnClickListener {
        val intent = Intent(applicationContext, PaymentMethodMainActivity::class.java)
        startActivity(intent)
    }
}
}