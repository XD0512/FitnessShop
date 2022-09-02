package com.example.fitnessshop.api


import com.example.fitnessshop.model.BaseResponse
import com.example.fitnessshop.model.Model
import com.example.newproject.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface Api {

    @GET("top-headlines?country=us&category=sports&apiKey=7b781c9a0bdd445abd8c8902e4f9308f")
    fun getSportsNews(): Call<BaseResponse<List<Model>>>

    @GET("everything?q=tesla&from=2022-08-01&sortBy=publishedAt&apiKey=7b781c9a0bdd445abd8c8902e4f9308f")
    fun getNews(
        /*@Query("q") q: String,
        @Query("from") from: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String,*/
    ): Call<BaseResponse<List<Article>>>
}