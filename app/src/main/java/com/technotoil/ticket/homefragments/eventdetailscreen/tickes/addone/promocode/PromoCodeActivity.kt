package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityPromoCodeBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.applyedcode.ApplyedCodeActivity

class PromoCodeActivity : BaseActivity<ActivityPromoCodeBinding, PromoModel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_promo_code
    }

    override fun getVmClass(): Class<PromoModel> {
        return PromoModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, ApplyedCodeActivity::class.java)
            startActivity(intent)

        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        val data2 = ArrayList<PromoDataModel>()
        binding.recycler.adapter = PromoAdapter(data2)
        data2.add(PromoDataModel("Taylor Swift"))
        data2.add(PromoDataModel("Taylor Swift"))
        data2.add(PromoDataModel("Taylor Swift"))
        data2.add(PromoDataModel("Taylor Swift"))
    }
}




