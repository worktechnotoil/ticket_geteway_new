package com.technotoil.ticket.homefragments.eventdetailscreen

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.technotoil.ticket.R
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityEventDetailsMainBinding
import com.technotoil.ticket.homefragments.eventdetailscreen.adapters.FollowingAdapter
import com.technotoil.ticket.homefragments.eventdetailscreen.adapters.SuggestionsAdapter
import com.technotoil.ticket.homefragments.eventdetailscreen.models.FollowingData
import com.technotoil.ticket.homefragments.eventdetailscreen.models.SuggestionsData
import com.technotoil.ticket.homefragments.eventdetailscreen.tickes.TicketsQuentityMainActivity
import java.text.SimpleDateFormat
import java.util.*


class EventDetailsMainActivity : BaseActivity<ActivityEventDetailsMainBinding, EventModel, Any?>() {
    companion object {
        var pageIndex = 0
    }


    override fun getLayout(): Int {
        return R.layout.activity_event_details_main
    }

    override fun getVmClass(): Class<EventModel> {
        return EventModel::class.java

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewPager.adapter = EventViewPagerAdapter(supportFragmentManager)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        setupSpinner()
        setupSpinner2()

        binding.ImageVie.setOnClickListener {
            finish()
        }
        //spinner_arrow
        // binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recycler.setHasFixedSize(true)
        val data = ArrayList<FollowingData>()
        binding.recycler.adapter = FollowingAdapter(data)

        data.add(FollowingData("#artist"))
        data.add(FollowingData("#events"))
        data.add(FollowingData("#Venue"))
        data.add(FollowingData("#edasd"))
        data.add(FollowingData("#Venue"))

        binding.recycler2.layoutManager = LinearLayoutManager(this)
        binding.recycler2.setHasFixedSize(true)
        val data2 = ArrayList<SuggestionsData>()
        binding.recycler2.adapter = SuggestionsAdapter(data2)
        data2.add(SuggestionsData("Sunburn reload NYE - toronto1"))
        data2.add(SuggestionsData("Sunburn reload NYE - toronto2"))
        data2.add(SuggestionsData("Sunburn reload NYE - toronto3"))
        data2.add(SuggestionsData("Sunburn reload NYE - toronto4"))
        binding.indicator.setViewPager(binding.viewPager)
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                changePage(position)
            }
        })


        binding.datepick.setOnClickListener {
            showDateDialog(binding.date4)
        }
        binding.ShowMap.setOnClickListener {
            val latitude = 37.7749
            val longitude = -122.4192
            val label = "Your location desired Aryan"
            val gmmIntentUri = Uri.parse("geo:0,0?q=$latitude,$longitude($label)")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
        binding.ticket.setOnClickListener {
            val intent = Intent(this,TicketsQuentityMainActivity::class.java);
            var userName = binding.mainText.text
            intent.putExtra("mainText", userName)

            startActivity(intent);

        }


    }

    private fun setupSpinner() {
        val personNames = arrayOf(
            "6:00 AM - 7:00 AM",
            "7:00 AM - 8:00 AM",
            "8:00 AM - 9:00 AM",
            "9:00 AM - 1:00 AM",
            "10:00 PM - 1:00 AM",
            "6:00 AM - 7:00 AM",
            "6:00 AM - 7:00 AM"
        )
        val spinner = binding.spinnerArrow
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                (view as TextView).text = null
                val text: String = parent.getItemAtPosition(position).toString()
                binding.time.text = text
//                Toast.makeText(
//                    this@EventDetailsMainActivity,
//                    getString(R.string.open) + " " + personNames[position],
//                    Toast.LENGTH_SHORT
//                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }

    private fun setupSpinner2() {
        val personNames = arrayOf(
            "Supermarket bar and Variety",
            "Supermarket bar and Variety 2",
            "Supermarket bar and Variety 3",
            "Supermarket bar and Variety 4",
            "1Supermarket bar and Variety 5",
            "Supermarket bar and Variety 7",
            "Supermarket bar and Variety 8",
            "Supermarket bar and Variety 9",
            "Supermarket bar and Variety 10"
        )
        val spinner = binding.spinnerArrow1
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, personNames)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                (view as TextView).text = null
                val text: String = parent.getItemAtPosition(position).toString()
                binding.date3.text = text
//                Toast.makeText(
//                    this@EventDetailsMainActivity,
//                    getString(R.string.open) + " " + personNames[position],
//                    Toast.LENGTH_SHORT
//                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
    }


    private fun showDateDialog(editDate: TextView?) {
        val calendar: Calendar = Calendar.getInstance()
        val dateSetListener =
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                calendar[Calendar.YEAR] = year
                calendar[Calendar.MONTH] = month
                calendar[Calendar.DAY_OF_MONTH] = dayOfMonth
                val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy")
                editDate?.text = simpleDateFormat.format(calendar.time)
            }
        DatePickerDialog(
            this,
            dateSetListener,
            calendar[Calendar.YEAR],
            calendar[Calendar.MONTH],
            calendar[Calendar.DAY_OF_MONTH]
        ).show()

    }


    private fun changePage(pageIndex: Int) {

        when (pageIndex) {

            0 -> {
                EventDetailsMainActivity.pageIndex = 0
                binding.indicator.setViewPager(binding.viewPager)
            }
            1 -> {
                EventDetailsMainActivity.pageIndex = 1
                binding.indicator.setViewPager(binding.viewPager)
            }
            2 -> {
                EventDetailsMainActivity.pageIndex = 2
                binding.indicator.setViewPager(binding.viewPager)
            }
            3 -> {
                EventDetailsMainActivity.pageIndex = 3
                binding.indicator.setViewPager(binding.viewPager)
            }
            4 -> {
                EventDetailsMainActivity.pageIndex = 4
                binding.indicator.setViewPager(binding.viewPager)
            }
            else -> {
                binding.indicator.setViewPager(binding.viewPager)
            }
        }
    }
}
