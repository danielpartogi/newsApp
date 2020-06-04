package com.example.core.data.remote

import com.example.core.data.api.NewsAPI
import com.example.core.models.NewsList
import retrofit2.HttpException
import javax.inject.Inject

class NewsRemoteSourceImpl @Inject constructor() : BaseRemoteSource<NewsAPI>(
    NewsAPI::class.java
), NewsRemoteSource {
    override suspend fun getNews(query: String, source: String): NewsList =
        try {
            api.getNews(query, source)
        } catch (exception: HttpException) {
            throw exception
        }
}
