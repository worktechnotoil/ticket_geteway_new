package com.technotoil.ticket.repository.remote

import androidx.databinding.ktx.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.String
import java.util.*
import java.util.concurrent.TimeUnit



object RetrofitBuilder {

    private val BASE_URL = String.format(
        Locale.US,
        "http://3.143.238.126/",
        com.technotoil.ticket.BuildConfig.FLAVOR
    )


    private val httpClient = OkHttpClient.Builder().connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(500, TimeUnit.SECONDS).writeTimeout(500, TimeUnit.SECONDS)
        .addInterceptor(getLoginInterceptor())
        .addInterceptor(Interceptor { chain: Interceptor.Chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder().header("Content-Type", "application/json")
            val request = requestBuilder.build()
            return@Interceptor chain.proceed(request)
        }).build()

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL).client(
            httpClient
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val apiService: ApiService = getRetrofit()
        .create(ApiService::class.java)

    private fun getLoginInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) (HttpLoggingInterceptor.Level.BODY) else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }
}