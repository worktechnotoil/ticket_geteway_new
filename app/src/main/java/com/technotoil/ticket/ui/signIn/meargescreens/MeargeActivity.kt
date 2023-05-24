package com.technotoil.ticket.ui.signIn.meargescreens

import android.os.Bundle
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityMeargeBinding

class MeargeActivity  : BaseActivity<ActivityMeargeBinding, MeargeModel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_mearge
    }
    override fun getVmClass(): Class<MeargeModel> {
        return MeargeModel::class.java
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}