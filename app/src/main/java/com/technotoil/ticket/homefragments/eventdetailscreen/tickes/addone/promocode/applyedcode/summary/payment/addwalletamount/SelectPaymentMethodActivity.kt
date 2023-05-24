package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.addwalletamount

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivitySelectPaymentMethodBinding

class SelectPaymentMethodActivity : BaseActivity<ActivitySelectPaymentMethodBinding, SelectPaymentMethodModel, Any?>() {
    private var areCheckBoxListenersLocked = false
    private inline fun CheckBox.setLockableListener(
        crossinline actionWhenUnlocked: (isChecked: Boolean) -> Unit
    ) {
        setOnCheckedChangeListener { _, isChecked ->
            if (!areCheckBoxListenersLocked) {
                areCheckBoxListenersLocked = true
                actionWhenUnlocked(isChecked)
                areCheckBoxListenersLocked = false
            }
        }
    }
    override fun getLayout(): Int {
        return R.layout.activity_select_payment_method
    }

    override fun getVmClass(): Class<SelectPaymentMethodModel> {
        return SelectPaymentMethodModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        clickEvent()

    }

    private fun clickEvent() {
        binding.back.setOnClickListener {
            finish()
        }
        binding.checkbox.setLockableListener { isChecked ->
            binding.checkbox2.isChecked = false
        }
        binding.checkbox2.setLockableListener { isChecked ->
            binding.checkbox.isChecked = false
        }
        binding.checkboxMorePay.setOnClickListener {
            binding.cardDetails.setVisibility(View.VISIBLE)
            binding.AtmCardDetails.setVisibility(View.GONE)

        }
        binding.spinnerArrow.setOnClickListener {
            binding.cardDetails.setVisibility(View.VISIBLE)
            binding.AtmCardDetails.setVisibility(View.GONE)

        }
        binding.upArrow.setOnClickListener {
            binding.cardDetails.setVisibility(View.GONE)
            binding.AtmCardDetails.setVisibility(View.VISIBLE)

        }
        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, WalletAddSuccessActivity::class.java)
            startActivity(intent)
        }
    }
}