package com.example.core.data.api

import com.example.core.models.NewsList
import com.example.core.models.SourceNewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("sources/")
    suspend fun getSources(
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = ConstantsData.API_KEY
    ): SourceNewsList

    @GET("everything/")
    suspend fun getNews(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("sources") source: String,
        @Query("apiKey") apiKey: String = ConstantsData.API_KEY
    ): NewsList
}