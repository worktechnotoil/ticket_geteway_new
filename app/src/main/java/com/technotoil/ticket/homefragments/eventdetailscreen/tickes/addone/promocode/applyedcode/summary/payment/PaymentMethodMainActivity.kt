package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityPaymentMethodMainBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.addwalletamount.SelectPaymentMethodActivity

class PaymentMethodMainActivity : BaseActivity<ActivityPaymentMethodMainBinding, PaymentModel, Any?>() {
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
        return R.layout.activity_payment_method_main
    }

    override fun getVmClass(): Class<PaymentModel> {
        return PaymentModel::class.java

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
            val intent = Intent(applicationContext, PaymentSuccessActivity::class.java)
            startActivity(intent)
        }
        binding.addPayment.setOnClickListener {
            val intent = Intent(applicationContext, SelectPaymentMethodActivity::class.java)
            startActivity(intent)
        }

    }


    }
