package com.dkgtech.newsapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dkgtech.newsapp.models.ArticleModel
import com.dkgtech.newsapp.models.NewsModel
import com.dkgtech.newsapp.repo.NewsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel(val newsRepository: NewsRepository) : ViewModel() {

    val listPhotos = MutableLiveData<List<ArticleModel>>()
    val listTitle = MutableLiveData<List<ArticleModel>>()
    val listDescription = MutableLiveData<List<ArticleModel>>()
    val errMsg = MutableLiveData<String>()

    fun getNews(auth: String, query: String) {

        newsRepository.getNews(auth, query).enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>?, response: Response<NewsModel>?) {
                if (response?.code() == 200) {
                    Log.d("Data", "${response.body()}")

                    listPhotos.postValue(response.body().articles)
                    listTitle.postValue(response.body().articles)
                    listDescription.postValue(response.body().articles)
                } else {
                    Log.d("Error", "${response?.errorBody()}, ${response?.code()}")
                    errMsg.postValue(
                        "Error : ${
                            response?.errorBody()
                        },${
                            response?.code()
                        }"
                    )
                }
            }

            override fun onFailure(call: Call<NewsModel>?, t: Throwable?) {
                Log.d("Network Error", "${t?.message}")
                t?.printStackTrace()
                errMsg.postValue("Network Error : ${t?.message}")
            }

        })

    }
}