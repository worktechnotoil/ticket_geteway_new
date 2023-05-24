package com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityAddOneBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.promocode.PromoCodeActivity

class AddOneActivity : BaseActivity<ActivityAddOneBinding, AddOneModel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_add_one
    }

    override fun getVmClass(): Class<AddOneModel> {
        return AddOneModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.ImageVie.setOnClickListener {
//            binding.pBar.visibility = View.VISIBLE
            finish()
        }

        binding.btnLayout.setOnClickListener {
            val intent = Intent(applicationContext, PromoCodeActivity::class.java)
            startActivity(intent)

        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        val data2 = ArrayList<AddOneDataModel>()

        binding.recycler.adapter = AddOneAdapter(data2)
        data2.add(AddOneDataModel(R.drawable.pepsi,"+ Pepsi","\$ 10.00"))
        data2.add(AddOneDataModel(R.drawable.newbanner,"+ Cups","\$ 60.00"))
        data2.add(AddOneDataModel(R.drawable.food,"+ Veg","\$ 0.00"))
        data2.add(AddOneDataModel(R.drawable.newbanner,"+ Non-Veg","\$ 60.00"))
        data2.add(AddOneDataModel(R.drawable.pepsi,"+ Pepsi","\$ 600.00"))
        data2.add(AddOneDataModel(R.drawable.newbanner,"+ Cups","\$ 60.00"))
        data2.add(AddOneDataModel(R.drawable.food,"+ Veg","\$ 60.00"))
        data2.add(AddOneDataModel(R.drawable.newbanner,"+ Non-Veg","\$ 60.00"))



    }
}




