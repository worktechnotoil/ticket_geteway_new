//package com.technotoil.ticket.homefragments.sidemenufragments.artists.trendingvenues
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.technotoil.ticket.R
//import com.technotoil.ticket.databinding.FragmentTrendingVenuesBinding
//
//class TrendingVenuesFragment : Fragment() {
//    private lateinit var imageId: Array<Int>
//    private lateinit var heading: Array<String>
//
//
//    private lateinit var adapter2: TrendingVenuesAdapter
//    private lateinit var dataList: ArrayList<TrendingVenuesDataModel>
//
//
//    private var _binding: FragmentTrendingVenuesBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//
//        _binding = FragmentTrendingVenuesBinding.inflate(inflater, container, false)
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
//
//
//        val layoutManager2 = LinearLayoutManager(context)
//        binding.recyclerData.layoutManager = layoutManager2
//        binding.recyclerData.setHasFixedSize(true)
//        adapter2 = TrendingVenuesAdapter(dataList)
//        binding.recyclerData.adapter = adapter2
//
//    }
//
//    private fun data_initilized() {
//        dataList = arrayListOf<TrendingVenuesDataModel>()
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
//            "Toronto Plaza Hotel",
//            "Toronto Plaza Hotel",
//            "Toronto Plaza Hotel",
//            "Toronto Plaza Hotel",
//            "Toronto Plaza Hotel",
//
//            )
//
//
//        for (i in imageId.indices) {
//            val data = TrendingVenuesDataModel(imageId[i], heading[i])
//            dataList.add(data)
//        }
//
//    }
//
//
//
//}