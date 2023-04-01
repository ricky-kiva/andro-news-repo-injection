package com.dicoding.newsapp.data.remote.retrofit

import com.dicoding.newsapp.data.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // this is what's being called: https://newsapi.org/v2/top-headlines?country=id&category=science&apiKey=apiKey
    @GET("top-headlines?country=us&category=science")
    fun getNews(@Query("apiKey") apiKey: String): Call<NewsResponse>
}