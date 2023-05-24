package com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.technotoil.ticket.databinding.FragmentManageEventBinding


class ManageEventFragment :Fragment() {
//    lateinit var tabLayout: TabLayout
//    lateinit var viewPager: ViewPager



    private var _binding: FragmentManageEventBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentManageEventBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Football"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Cricket"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("NBA"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("NBA"))
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("NBA"))
//        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
//        val adapter = ViewPagerAdapter(this, childFragmentManager,
//            binding.tabLayout.tabCount)
//       binding.viewPager.adapter = adapter
//        binding.viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabLayout))
//        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab) {
//                binding.viewPager.currentItem = tab.position
//            }
//            override fun onTabUnselected(tab: TabLayout.Tab) {}
//            override fun onTabReselected(tab: TabLayout.Tab) {}
//        })




    }




}