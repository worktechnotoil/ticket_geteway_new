package com.technotoil.ticket.homefragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.technotoil.ticket.Listener.Listener
import com.technotoil.ticket.R
import com.technotoil.ticket.databinding.FragmentHomeBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.EventDetailsMainActivity


class HomeFragment : Fragment(), Listener {

    private lateinit var adapter: HomeMainAdapter
    private lateinit var adapter2: FeaturedEventsAdapter
    private lateinit var adapter3: OrganizersFollowAdapter
    private lateinit var adapter4: CategoryGridAdapter
    private lateinit var newsArrayList: ArrayList<Homedata>
    private lateinit var dataArrayList: ArrayList<OrganizersData>


    lateinit var courseList: List<CategoryGridViewModal>


    private lateinit var imageId: Array<Int>
    private lateinit var heading: Array<String>
    private lateinit var news: Array<String>


    private var _binding: FragmentHomeBinding? = null
    lateinit var adapterq: HomeMainAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        datainitilized()

        val layoutManager = LinearLayoutManager(context)
        binding.recycler.layoutManager = layoutManager
        binding.recycler.setHasFixedSize(true)
        adapter = HomeMainAdapter(newsArrayList, this)
        binding.recycler.adapter = adapter


        val layoutManager2 = LinearLayoutManager(context)
        binding.recycler2.layoutManager = layoutManager2
        binding.recycler2.setHasFixedSize(true)
        adapter2 = FeaturedEventsAdapter(newsArrayList)
        binding.recycler2.adapter = adapter2


        val layoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler3.layoutManager = layoutManager3
        binding.recycler3.setHasFixedSize(true)
        adapter3 = OrganizersFollowAdapter(dataArrayList)
        binding.recycler3.adapter = adapter3

//
//        courseList = courseList + CategoryGridViewModal("C++", R.drawable.carniva)
//        courseList = courseList + CategoryGridViewModal("Java", R.drawable.music)
//        courseList = courseList + CategoryGridViewModal("Android", R.drawable.carniva)
//        courseList = courseList + CategoryGridViewModal("Python", R.drawable.music)
//        courseList = courseList + CategoryGridViewModal("Javascript", R.drawable.carniva)


    }

    private fun datainitilized() {
        newsArrayList = arrayListOf<Homedata>()
        dataArrayList = arrayListOf<OrganizersData>()

        imageId = arrayOf(
            R.drawable.newbanner,
            R.drawable.newbanner,
            R.drawable.girl,
            R.drawable.girl,
            R.drawable.girl,

            )
        heading = arrayOf(
            "Events near Toronto",
            "Events near Toronto",
            "Events near Toronto",
            "Events near Toronto",
            "Events near Toronto",

            )

        for (i in imageId.indices) {
            val news = Homedata(imageId[i], heading[i])
            newsArrayList.add(news)
        }
        for (i in imageId.indices) {
            val data = OrganizersData(imageId[i], heading[i])
            dataArrayList.add(data)
        }
    }

    override fun onItemClickListener(position: Int) {
        val intent = Intent(context, EventDetailsMainActivity::class.java)
        startActivity(intent)
        //  Toast.makeText(context,newsArrayList[position].titleImage,Toast.LENGTH_SHORT).show()

    }

}