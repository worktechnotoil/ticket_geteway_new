package models

import com.google.gson.annotations.SerializedName





    data class CreateAccountResponse (

        @SerializedName("data"        ) var data       : Data?   = Data(),
        @SerializedName("status_code" ) var statusCode : Int?    = null,
        @SerializedName("message"     ) var message    : String? = null,
        @SerializedName("error"       ) var error      : String? = null

    )
data class Data (

    @SerializedName("title"                      ) var title                   : String?  = null,
    @SerializedName("home_phone"                 ) var homePhone               : String?  = null,
    @SerializedName("role"                       ) var role                    : String?  = null,
    @SerializedName("full_name"                  ) var fullName                : String?  = null,
    @SerializedName("cell_phone"                 ) var cellPhone               : String?  = null,
    @SerializedName("username"                   ) var username                : String?  = null,
    @SerializedName("suffix"                     ) var suffix                  : String?  = null,
    @SerializedName("status"                     ) var status                  : String?  = null,
    @SerializedName("signature"                  ) var signature               : String?  = null,
    @SerializedName("id"                         ) var id                      : Int?     = null,
    @SerializedName("password"                   ) var password                : String?  = null,
    @SerializedName("allow_to_create_costume"    ) var allowToCreateCostume    : Boolean? = null,
    @SerializedName("admin_type"                 ) var adminType               : String?  = null,
    @SerializedName("created_at"                 ) var createdAt               : String?  = null,
    @SerializedName("email"                      ) var email                   : String?  = null,
    @SerializedName("allow_to_reserve_sittings"  ) var allowToReserveSittings  : Boolean? = null,
    @SerializedName("allow_super_promoter_login" ) var allowSuperPromoterLogin : String?  = null,
    @SerializedName("updated_at"                 ) var updatedAt               : String?  = null,
    @SerializedName("gender"                     ) var gender                  : String?  = null,
    @SerializedName("allow_all_type_of_cards"    ) var allowAllTypeOfCards     : Boolean? = null,
    @SerializedName("is_admin_user"              ) var isAdminUser             : Boolean? = null,
    @SerializedName("created_by"                 ) var createdBy               : String?  = null,
    @SerializedName("dob"                        ) var dob                     : String?  = null,
    @SerializedName("country"                    ) var country                 : String?  = null,
    @SerializedName("is_admin_tour_completed"    ) var isAdminTourCompleted    : Boolean? = null,
    @SerializedName("updated_by"                 ) var updatedBy               : String?  = null,
    @SerializedName("is_verify"                  ) var isVerify                : Boolean? = null

)