package com.dkgtech.newsapp

import com.dkgtech.newsapp.models.NewsModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiHelper {

    @GET("everything")
    fun getNews(
        @Header("Authorization") auth: String,
        @Query("query") query: String,
    ): Call<NewsModel>

    companion object {
        val BASE_URL = "https://newsapi.org/v2/"

        fun create(): ApiHelper {

            val retrofitClient = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofitClient.create(ApiHelper::class.java)
        }

    }

}