package com.example.core.data.api

import com.example.core.models.SourceNewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {
    @GET("sources/")
    suspend fun getSources(
        @Query("sources") category: String,
        @Query("apiKey") apiKey: String = "dfd6b1e460764bccb4dbcb387f0c331a"
    ): SourceNewsList

}