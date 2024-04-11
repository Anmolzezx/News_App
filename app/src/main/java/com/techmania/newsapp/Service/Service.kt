package com.techmania.newsapp.Service

import com.techmania.newsapp.db.News
import com.techmania.newsapp.utils.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface Service {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "in",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY,

        ): Response<News>

    @GET("v2/everything")
    suspend fun getByCategory(
        @Query("q")
        countryCode: String = "",
        @Query("apiKey")
        apiKey: String = API_KEY,

        ): Response<News>
}