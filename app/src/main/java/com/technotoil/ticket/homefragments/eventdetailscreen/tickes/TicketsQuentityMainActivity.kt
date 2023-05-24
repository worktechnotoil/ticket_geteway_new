package com.technotoil.ticket.homefragments.eventdetailscreen.tickes

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityTicketsQuentityMainBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.addone.AddOneActivity

class TicketsQuentityMainActivity:BaseActivity<ActivityTicketsQuentityMainBinding,TicketsQuentitymodel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_tickets_quentity_main
    }
    override fun getVmClass(): Class<TicketsQuentitymodel> {
        return TicketsQuentitymodel::class.java

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
            val intent = Intent(applicationContext, AddOneActivity::class.java)
            startActivity(intent)
        }


        var strUser: String? = intent.getStringExtra("mainText")

        binding.headindMain.setText(strUser)
        binding.ImageVie.setOnClickListener {
            finish()
        }
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.setHasFixedSize(true)
        val data2 = ArrayList<QuentityDataModel>()
        binding.recycler.adapter = QuentityAdapter(data2)
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))
        data2.add(QuentityDataModel("Taylor Swift"))

    }
}




