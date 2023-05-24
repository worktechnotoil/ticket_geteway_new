package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityOrderSummaryBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.payment.PaymentMethodMainActivity

class OrderSummaryActivity : BaseActivity<ActivityOrderSummaryBinding, OrderSummaryModel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_order_summary
    }

    override fun getVmClass(): Class<OrderSummaryModel> {
        return OrderSummaryModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, PaymentMethodMainActivity::class.java)
            startActivity(intent)

        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        val data2 = ArrayList<OrderSummaryDataModel>()
        binding.recycler.adapter = OrderSummaryAdapter(data2)
        data2.add(OrderSummaryDataModel("VIP Admission"))


    }
}




