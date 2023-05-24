package com.technotoil.ticket.ui.welcomeUser

import PageAdapter
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.ActivityWelcomeBinding


class WelcomeActivity : BaseActivity<ActivityWelcomeBinding, WelcomeViewModel, Any?>() {

   companion object {
       var pageIndex=0
   }



    override fun getLayout(): Int {
        return com.technotoil.ticket.R.layout.activity_welcome
    }

    override fun getVmClass(): Class<WelcomeViewModel> {
        return WelcomeViewModel::class.java
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewPager.adapter = PageAdapter(supportFragmentManager)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.skipText.visibility=View.GONE

        binding.viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                changePage(position)
            }

        })

        binding.nextIntroSlide.setOnClickListener {
            pageIndex += 1
            if(pageIndex>2){
                viewModel.openGetStartedActivity(this)
            }else{
                binding.viewPager.setCurrentItem(pageIndex)
                changePage(pageIndex)
            }
        }

        binding.skipText.setOnClickListener {
            viewModel.openGetStartedActivity(this)
        }
    }

    private fun changePage(pageIndex :Int){

        when (pageIndex) {

            0 -> {
                Companion.pageIndex = 0

                binding.skipText.visibility=View.GONE
                binding.nextText.text="Text"
                binding.sliderDots.setImageDrawable(resources.getDrawable(com.technotoil.ticket.R.drawable.ic_slider1))
            }
            1 -> {
                Companion.pageIndex = 1
                binding.nextText.text="Text"
                binding.skipText.visibility=View.VISIBLE
                binding.sliderDots.setImageDrawable(resources.getDrawable(com.technotoil.ticket.R.drawable.ic_slider2))
            }
            2 -> {
                Companion.pageIndex = 2
                binding.skipText.visibility=View.GONE
                binding.nextText.text="Finish"
                binding.sliderDots.setImageDrawable(resources.getDrawable(com.technotoil.ticket.R.drawable.ic_slide3))
            }
            else -> {
                binding.skipText.visibility=View.GONE
                binding.nextText.text="Text"
                binding.sliderDots.setImageDrawable(resources.getDrawable(com.technotoil.ticket.R.drawable.ic_slider1))
            }
        }
    }
}

