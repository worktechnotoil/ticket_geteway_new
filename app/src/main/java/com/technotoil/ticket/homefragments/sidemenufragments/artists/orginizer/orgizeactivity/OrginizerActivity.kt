package com.technotoil.ticket.homefragments.sidemenufragments.artists.orginizer.orgizeactivity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityOrginizerBinding

class OrginizerActivity : BaseActivity<ActivityOrginizerBinding, OrginizerModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_orginizer
    }

    override fun getVmClass(): Class<OrginizerModel> {
        return OrginizerModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.ImageVie.setOnClickListener {
//            binding.pBar.visibility = View.VISIBLE
            finish()
        }

        binding.recyclerHorizontal.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHorizontal.setHasFixedSize(true)
        val data = ArrayList<OrginizerSuggestDataModel>()
        binding.recyclerHorizontal.adapter = TrendingOrganizersAdapter(data)
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))
        data.add(OrginizerSuggestDataModel("Tony chankar"))


        binding.recyclerSuggest.layoutManager = LinearLayoutManager(this)
        binding.recyclerSuggest.setHasFixedSize(true)
        val data2 = java.util.ArrayList<TrendingOrganizersModel>()
        binding.recyclerSuggest.adapter = SuggestForAdapter(data2)
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))
        data2.add(TrendingOrganizersModel("Taylor Swift"))



//        binding.recyclerSuggest.layoutManager = LinearLayoutManager(this)
//        binding.recyclerSuggest.setHasFixedSize(true)
//        val data2 = ArrayList<SuggestionsData>()
//        binding.recyclerSuggest.adapter = SuggestionsAdapter(data2)




    }




}
