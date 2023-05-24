package models

import com.google.gson.annotations.SerializedName

data class EmailSignupModel (

    @SerializedName("data"        ) var data       : String? = null,
    @SerializedName("status_code" ) var statusCode : Int?    = null,
    @SerializedName("message"     ) var message    : String? = null,
    @SerializedName("error"       ) var error      : String? = null

 )