package com.example.core.data.remote

import com.example.core.models.NewsList

interface NewsRemoteSource {
    suspend fun getNews(query: String, source: String) : NewsList
}