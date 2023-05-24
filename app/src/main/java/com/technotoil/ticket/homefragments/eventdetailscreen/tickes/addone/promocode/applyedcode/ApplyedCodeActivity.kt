package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityApplyedCodeBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.summary.OrderSummaryActivity

class ApplyedCodeActivity : BaseActivity<ActivityApplyedCodeBinding, ApplyedModel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_applyed_code
    }

    override fun getVmClass(): Class<ApplyedModel> {
        return ApplyedModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, OrderSummaryActivity::class.java)
            startActivity(intent)

        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        val data2 = ArrayList<ApplyedDataModel>()
        binding.recycler.adapter = ApplyedAdapter(data2)
        data2.add(ApplyedDataModel("VIP Admission"))
        data2.add(ApplyedDataModel("VIP Admission"))
        data2.add(ApplyedDataModel("VIP Admission"))
        data2.add(ApplyedDataModel("VIP Admission"))


    }
}




