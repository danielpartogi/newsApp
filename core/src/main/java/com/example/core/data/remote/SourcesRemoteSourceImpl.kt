package com.example.core.data.remote

import com.example.core.data.api.NewsAPI
import com.example.core.models.SourceNewsList
import retrofit2.HttpException
import javax.inject.Inject

class SourcesRemoteSourceImpl @Inject constructor() : BaseRemoteSource<NewsAPI>(
    NewsAPI::class.java
), SourcesRemoteSource {
    override suspend fun getSources(category: String): SourceNewsList =
        try {
            api.getSources(category)
        } catch (exception: HttpException) {
            throw exception
        }

}
