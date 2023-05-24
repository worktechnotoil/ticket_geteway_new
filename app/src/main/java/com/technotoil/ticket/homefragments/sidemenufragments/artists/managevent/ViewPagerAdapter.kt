package com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

internal  class ViewPagerAdapter(
    var context: ManageEventActivity,
    fm: FragmentManager,
    var totalTabs: Int
) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                AllDataFragment()
            }
            1 -> {
                ManageEventFragment()
            }
            2 -> {
                ManageEventFragment()
            }
            3 -> {
                ManageEventFragment()
            }
            4 -> {
                ManageEventFragment()
            }
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs
    }
    }