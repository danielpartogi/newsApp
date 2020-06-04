package com.example.core.data.repositories

import com.example.core.data.remote.NewsRemoteSource
import com.example.core.models.Article
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remoteSource: NewsRemoteSource
) : NewsRepository {
    override suspend fun getNews(query:String, page: Int, source:String): List<Article>? {
        return remoteSource.getNews(query,page,source).articles
    }
}