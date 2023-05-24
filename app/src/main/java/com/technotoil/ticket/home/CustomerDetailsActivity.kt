package com.technotoil.ticket.home

import android.os.Bundle
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityCustomerDetailsBinding

class CustomerDetailsActivity (): BaseActivity<ActivityCustomerDetailsBinding, CustomerDetailModel, Any?>() {
    override fun getLayout(): Int {
        return R.layout.activity_customer_details
    }
    override fun getVmClass(): Class<CustomerDetailModel> {
        return CustomerDetailModel::class.java
    }
//
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)


}
}