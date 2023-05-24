package com.technotoil.ticket.homefragments.eventdetailscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class EventViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 5;
    }

    override fun getItem(position: Int): Fragment {
        when(position) {
            0 -> {
                return Banner1Fragment()
            }
            1 -> {
                return Banner2Fragment()
            }
            2 -> {
                return Banner3Fragment()
            }
            3 -> {
                return Banner4Fragment()
            }
            4 -> {
                return Banner5Fragment()
            }
            else -> {
                return Banner1Fragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
            2 -> {
                return "Tab 3"
            }
        }
        return super.getPageTitle(position)
    }

}
