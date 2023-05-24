package com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.R
import com.technotoil.ticket.databinding.FragmentAllDataBinding


class AllDataFragment : Fragment() {



    private lateinit var dataArrayList: ArrayList<AllFragmentDataModel>
    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>


    private lateinit var adapter: AllFragmentAdapter



    private var _binding: FragmentAllDataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAllDataBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data_initilized()




        val layoutManager2 = LinearLayoutManager(context)
        binding.recycler?.layoutManager = layoutManager2
        binding.recycler?.setHasFixedSize(true)
        adapter = AllFragmentAdapter(dataArrayList)
        binding.recycler?.adapter = adapter

    }

    private fun data_initilized() {
        dataArrayList = arrayListOf<AllFragmentDataModel>()

        dataArrayList = arrayListOf<AllFragmentDataModel>()


        imageId = arrayOf(
            R.drawable.newbanner,
            R.drawable.newbanner,
            R.drawable.flowers,
            R.drawable.flowers,
            R.drawable.flowers,

            )
        heading = arrayOf(
            "Manage",
            "Manage",
            "Manage",
            "Manage",
            "Manage",

            )

        for (i in imageId.indices) {
            val data = AllFragmentDataModel(imageId[i], heading[i])
            dataArrayList.add(data)
        }


    }



}