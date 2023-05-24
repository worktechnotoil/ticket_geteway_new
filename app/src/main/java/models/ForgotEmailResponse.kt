package models

import com.google.gson.annotations.SerializedName



    data class ForgotEmailResponse (

        @SerializedName("data"        ) var data       : ForgotEmail?   = ForgotEmail(),
        @SerializedName("status_code" ) var statusCode : Int?    = null,
        @SerializedName("message"     ) var message    : String? = null,
        @SerializedName("error"       ) var error      : String? = null

    )





data class ForgotEmail (

    @SerializedName("is_verify"              ) var isVerify             : Boolean? = null,
    @SerializedName("reset_token"            ) var resetToken           : String?  = null,
    @SerializedName("user_id"                ) var userId               : Int?     = null,
    @SerializedName("id"                     ) var id                   : Int?     = null,
    @SerializedName("reset_token_expiration" ) var resetTokenExpiration : String?  = null

)