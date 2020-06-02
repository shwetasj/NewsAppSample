package com.example.newsassignment

import com.example.newsassignment.model.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.http.Url
import java.util.ArrayList

interface NewsApi {

    @GET("top-headlines")
    fun getPaymentTypes(@Query("country") country: String, @Query("apiKey") apiKey: String, @Query("pageSize") page: Int): Call<BaseModel<ArrayList<NewsData>>>

}