package com.technotoil.ticket.ui.otpVerify

import com.google.gson.annotations.SerializedName


    data class MobileOtpVerifyResponse (


        @SerializedName("user_name" ) var userName : String? = null,
        @SerializedName("email"     ) var email    : String? = null,
        @SerializedName("name"      ) var name     : String? = null


    )
