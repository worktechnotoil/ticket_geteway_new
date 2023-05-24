package com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent.artistactivity

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityArtistsBinding

class ArtistsActivity :BaseActivity<ActivityArtistsBinding, ArtistModel, Any?>() {

    override fun getLayout(): Int {
        return R.layout.activity_artists
    }

    override fun getVmClass(): Class<ArtistModel> {
        return ArtistModel::class.java

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
        val data = ArrayList<OrginizireDataModel>()
        binding.recyclerHorizontal.adapter = ArtistsOrginizireAdapter(data)
        data.add(OrginizireDataModel("Tony chankar & company"))
        data.add(OrginizireDataModel("Rebecca young"))
        data.add(OrginizireDataModel("Rebecca young"))
        data.add(OrginizireDataModel("Rebecca young"))
        data.add(OrginizireDataModel("Rebecca young"))
        data.add(OrginizireDataModel("Rebecca young"))
        data.add(OrginizireDataModel("Rebecca young"))
        data.add(OrginizireDataModel("Rebecca young"))


        binding.recyclerSuggest.layoutManager = LinearLayoutManager(this)
        binding.recyclerSuggest.setHasFixedSize(true)
        val data2 = java.util.ArrayList<SuggestDataModel>()
        binding.recyclerSuggest.adapter = SuggestforyouAdapter(data2)
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))
        data2.add(SuggestDataModel("Taylor Swift"))



//        binding.recyclerSuggest.layoutManager = LinearLayoutManager(this)
//        binding.recyclerSuggest.setHasFixedSize(true)
//        val data2 = ArrayList<SuggestionsData>()
//        binding.recyclerSuggest.adapter = SuggestionsAdapter(data2)




    }




}
