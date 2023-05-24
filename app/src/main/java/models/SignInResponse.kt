package models


import com.google.gson.annotations.SerializedName


data class SignInResponse (

    @SerializedName("data"        ) var data       : SigninData?   = SigninData(),
    @SerializedName("status_code" ) var statusCode : Int?    = null,
    @SerializedName("message"     ) var message    : String? = null,
    @SerializedName("error"       ) var error      : String? = null

)




data class SigninData (

    @SerializedName("id"            ) var id           : Int?    = null,
    @SerializedName("full_name"     ) var fullName     : String? = null,
    @SerializedName("email"         ) var email        : String? = null,
    @SerializedName("access_token"  ) var accessToken  : String? = null,
    @SerializedName("refresh_token" ) var refreshToken : String? = null

)