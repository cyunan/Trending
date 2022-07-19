package com.bundletool.trending

import android.icu.text.DateFormat.Field.SECOND
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.Calendar.SECOND
import java.util.concurrent.TimeUnit

/**
 *    author : ChenYuNan
 *    date   : 2022/7/19
 *    desc   :
 */
object RetrofitClient {
    private const val TAG = "OKHTTP"
    private const val BASE_URL = "https://baseUrl.com/"
    private const val TIME_OUT = 10
    val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    val service by lazy { getService(RepoService::class.java, BASE_URL) }
    private val client: OkHttpClient by lazy {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        builder.build()
    }

    private fun <S> getService(
        serviceClass: Class<S>,
        baseUrl: String,
        client: OkHttpClient = this.client
    ): S{
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
            .create(serviceClass)
    }

}