package com.dkgtech.newsapp.repo

import com.dkgtech.newsapp.ApiHelper
import com.dkgtech.newsapp.models.NewsModel
import retrofit2.Call

class NewsRepository(val apiHelper: ApiHelper) {

    fun getNews(
        auth: String,
        query: String
    ): Call<NewsModel> {
        return apiHelper.getNews(auth = auth, query = query)
    }
}