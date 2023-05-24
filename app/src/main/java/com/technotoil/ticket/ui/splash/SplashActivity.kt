package com.technotoil.ticket.ui.splash

import android.os.Bundle
import com.technotoil.ticket.base.BaseActivity
import com.technotoil.ticket.databinding.SplashActivityBinding


class SplashActivity : BaseActivity<SplashActivityBinding, SplashViewModel, Any?>() {

    override fun getLayout(): Int {
        return com.technotoil.ticket.R.layout.splash_activity
    }

    override fun getVmClass(): Class<SplashViewModel> {
        return SplashViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        viewModel.setHandler(this)





//        val animation: Animation =
//            AnimationUtils.loadAnimation(applicationContext, com.technotoil.ticket.R.anim.anim)
//       binding.circle1.startAnimation(animation)
//        binding.circle2.startAnimation(animation)
//        binding.circle3.startAnimation(animation)
//
//
//        val scaleDownX = ObjectAnimator.ofFloat(com.technotoil.ticket.R.anim.anim, "scaleX", 0.5f)
//        val scaleDownY = ObjectAnimator.ofFloat(com.technotoil.ticket.R.anim.anim, "scaleY", 0.5f)
//        scaleDownX.duration = 1000
//        scaleDownY.duration = 1000
//
//        val scaleDown = AnimatorSet()
//        scaleDown.play(scaleDownX).with(scaleDownY)
//
//        scaleDown.start()

    }

}