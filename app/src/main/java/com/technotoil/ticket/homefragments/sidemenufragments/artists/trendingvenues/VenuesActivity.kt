package com.technotoil.ticket.homefragments.sidemenufragments.artists.trendingvenues

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityVenuesBinding

class VenuesActivity : BaseActivity<ActivityVenuesBinding, VenuesModel, Any?>() {
    companion object {
        var pageIndex = 0
    }


    override fun getLayout(): Int {
        return R.layout.activity_venues
    }

    override fun getVmClass(): Class<VenuesModel> {
        return VenuesModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.ImageVie.setOnClickListener {
//            binding.pBar.visibility = View.VISIBLE
            finish()
        }

        binding.recyclerData.layoutManager = LinearLayoutManager(this)
        binding.recyclerData.setHasFixedSize(true)
        val data2 = ArrayList<TrendingVenuesDataModel>()
        binding.recyclerData.adapter = TrendingVenuesAdapter(data2)
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))
        data2.add(TrendingVenuesDataModel("Taylor Swift"))




    }




}
