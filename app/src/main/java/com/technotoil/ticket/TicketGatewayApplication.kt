package com.technotoil.activity

import android.app.Application

class TicketGatewayApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: TicketGatewayApplication
            private set
    }

}