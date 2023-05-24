//package com.technotoil.ticket.homefragments.sidemenufragments.artists.orginizer
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.technotoil.ticket.R
//import com.technotoil.ticket.databinding.FragmentOrganizersBinding
//
//class OrganizersFragment :Fragment() {
//
//
//    private lateinit var adapter3: TrendingOrganizersAdapter
//    private lateinit var dataArrayList: ArrayList<OrginizerSuggestDataModel>
//    private lateinit var imageId: Array<Int>
//    private lateinit var heading: Array<String>
//
//
//    private lateinit var adapter2: SuggestForAdapter
//    private lateinit var dataList: ArrayList<TrendingOrganizersModel>
//
//
//    private var _binding: FragmentOrganizersBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        _binding = FragmentOrganizersBinding.inflate(inflater, container, false)
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
//        adapter3 = TrendingOrganizersAdapter(dataArrayList)
//        binding.recyclerHorizontal.adapter = adapter3
//
//        val layoutManager2 = LinearLayoutManager(context)
//        binding.recyclerSuggest?.layoutManager = layoutManager2
//        binding.recyclerSuggest?.setHasFixedSize(true)
//        adapter2 = SuggestForAdapter(dataList)
//        binding.recyclerSuggest?.adapter = adapter2
//
//    }
//
//    private fun data_initilized() {
//        dataArrayList = arrayListOf<OrginizerSuggestDataModel>()
//
//        dataList = arrayListOf<TrendingOrganizersModel>()
//
//        imageId = arrayOf(
//            R.drawable.newbanner,
//            R.drawable.newbanner,
//            R.drawable.flowers,
//            R.drawable.girl,
//            R.drawable.girl,
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
//            val data = OrginizerSuggestDataModel(imageId[i], heading[i])
//            dataArrayList.add(data)
//        }
//        for (i in imageId.indices) {
//            val data = TrendingOrganizersModel(imageId[i], heading[i])
//            dataList.add(data)
//        }
//
//    }
//
//
//
//}