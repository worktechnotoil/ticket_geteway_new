//package com.technotoil.ticket.homefragments.sidemenufragments.artists
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.technotoil.ticket.R
//import com.technotoil.ticket.databinding.FragmentArtistsBinding
//
//
//class ArtistsFragment:  Fragment() {
//
//
//    private lateinit var adapter3: ArtistsOrginizireAdapter
//    private lateinit var dataArrayList: ArrayList<OrginizireDataModel>
//    private lateinit var imageId: Array<Int>
//    private lateinit var heading: Array<String>
//
//
//    private lateinit var adapter2: SuggestforyouAdapter
//    private lateinit var dataList: ArrayList<SuggestDataModel>
//
//
//    private var _binding: FragmentArtistsBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        _binding = FragmentArtistsBinding.inflate(inflater, container, false)
//
//        return binding.root
//
//
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        data_initilized()
//
//
//
//        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        binding.recyclerHorizontal.layoutManager = layoutManager
//        binding.recyclerHorizontal.setHasFixedSize(true)
//        adapter3 = ArtistsOrginizireAdapter(dataArrayList)
//        binding.recyclerHorizontal.adapter = adapter3
//
//        val layoutManager2 = LinearLayoutManager(context)
//        binding.recyclerSuggest?.layoutManager = layoutManager2
//        binding.recyclerSuggest?.setHasFixedSize(true)
//        adapter2 = SuggestforyouAdapter(dataList)
//        binding.recyclerSuggest?.adapter = adapter2
//
//    }
//
//    private fun data_initilized() {
//        dataArrayList = arrayListOf<OrginizireDataModel>()
//
//        dataList = arrayListOf<SuggestDataModel>()
//
//
//        imageId = arrayOf(
//            R.drawable.newbanner,
//            R.drawable.newbanner,
//            R.drawable.flowers,
//            R.drawable.flowers,
//            R.drawable.flowers,
//
//            )
//        heading = arrayOf(
//            "Events near Toronto",
//            "Events near Toronto",
//            "Events near Toronto",
//            "Events near Toronto",
//            "Events near Toronto",
//
//            )
//
//        for (i in imageId.indices) {
//            val data = OrginizireDataModel(imageId[i], heading[i])
//            dataArrayList.add(data)
//        }
//        for (i in imageId.indices) {
//            val data = SuggestDataModel(imageId[i], heading[i])
//            dataList.add(data)
//        }
//
//    }
//
//
//
//}