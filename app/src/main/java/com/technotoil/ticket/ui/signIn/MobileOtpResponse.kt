package com.technotoil.ticket.ui.signIn

import com.google.gson.annotations.SerializedName
import java.io.Serializable


class MobileOtpResponse (

    @SerializedName("data"        ) var data       : ArrayList<MobileOTPResponseData> = arrayListOf(),
    @SerializedName("status_code" ) var statusCode : Int?            = null,
    @SerializedName("message"     ) var message    : String?         = null,
    @SerializedName("error"       ) var error      : String?         = null

)

data class MobileOTPResponseData (

    @SerializedName("email"     ) var email    : String? = null,
    @SerializedName("full_name" ) var fullName : String? = null

) : Serializable