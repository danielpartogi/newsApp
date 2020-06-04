package com.example.core.data.repositories

import com.example.core.models.Article

interface NewsRepository {
    suspend fun getNews(query:String, source:String): List<Article>?
}