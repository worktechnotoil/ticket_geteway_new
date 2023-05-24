package com.technotoil.ticket.homefragments.sidemenufragments.artists.managevent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.technotoil.ticket.R

class ManageEventActivity : AppCompatActivity(){
    lateinit var tabLayout: TabLayout
lateinit var viewPager: ViewPager

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_manage_event)
    tabLayout = findViewById(R.id.tabLayout)
    viewPager = findViewById(R.id.viewPager)
    tabLayout.addTab(tabLayout.newTab().setText("All"))
    tabLayout.addTab(tabLayout.newTab().setText("Live"))
    tabLayout.addTab(tabLayout.newTab().setText("Upcoming"))
    tabLayout.addTab(tabLayout.newTab().setText("Past"))
    tabLayout.addTab(tabLayout.newTab().setText("Other"))
    tabLayout.tabGravity = TabLayout.GRAVITY_FILL


    val adapter = ViewPagerAdapter(this, supportFragmentManager,
        tabLayout.tabCount)
    viewPager.adapter = adapter
    viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            viewPager.currentItem = tab.position
        }
        override fun onTabUnselected(tab: TabLayout.Tab) {}
        override fun onTabReselected(tab: TabLayout.Tab) {}
    })
}
}