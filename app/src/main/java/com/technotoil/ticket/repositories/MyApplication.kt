package com.technotoil.ticket.repositories

import android.app.Application

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        MyPreferences.init(this)
    }
}