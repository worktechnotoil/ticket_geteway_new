package com.technotoil.ticket.repository.remote

import com.google.gson.JsonObject
import com.technotoil.ticket.ui.otpVerify.MobileOtpVerifyResponse
import com.technotoil.ticket.ui.signIn.EmailMergeResponse
import com.technotoil.ticket.ui.signIn.MobileOtpResponse
import models.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiService  {
    @Headers(
        "Accept: application/json",
        "Content-type:application/json")

    @POST("auth/signup-email/")

    fun SignUpEmail(
        @Body body : Map<String,String>,
    ): Call<EmailSignupModel?>?


    @Headers(
        "Accept: application/json",
        "Content-type:application/json")

    @POST("auth/verify-otp/")
    fun VerifyOtp(@Body body : Map<String,String>,
    ): Call<VeriFyOtpResponse?>?

    @Headers(
        "Accept: application/json",
        "Content-type:application/json")

    @POST("/auth/register/")
    fun createAccountAPI(@Body body : Map<String,String>,
    ): Call<CreateAccountResponse?>?

    @Headers(
        "Accept: application/json",
        "Content-type:application/json")

    @POST("/auth/user/login/")
    fun signINEmailAPI(@Body body : Map<String,String>,
    ): Call<SignInResponse?>?

    @Headers(
        "Accept: application/json",
        "Content-type:application/json")
    @POST("/auth/user/forget-password/")
    fun forgotEmailAPI(@Body body : Map<String,String>,
    ): Call<ForgotEmailResponse?>?

    @Headers(
        "Accept: application/json",
        "Content-type:application/json")
    @POST("/auth/user/login/mobile/")
    fun signINMobileAPI(@Body body : Map<String,String>,
    ): Call<JsonObject>?


    @Headers(
        "Accept: application/json",
        "Content-type:application/json")
    @POST("/auth/user/login/mobile/")
    fun mobileOtpVerifyAPI(@Body body : Map<String,String>,
    ): Call<MobileOtpVerifyResponse?>?


    @Headers(
        "Accept: application/json",
        "Content-type:application/json")
    @POST("/auth/user/login/mobile/otp/verify/")
    fun mobileOtpVerify(@Body body : Map<String,String>,
    ): Call<MobileOtpResponse?>?

    @Headers(
        "Accept: application/json",
        "Content-type:application/json")
    @POST("auth/user/mobile-linked/email/login/")
    fun mergeEmailApi(@Body body : Map<String,String>,
    ): Call<EmailMergeResponse>?

    @Headers(
        "Accept: application/json",
        "Content-type:application/json")
    @POST("/auth/user/reset-password/")
    fun newPinSetApi(@Body body : Map<String,String>,
    ): Call<JsonObject>?

}