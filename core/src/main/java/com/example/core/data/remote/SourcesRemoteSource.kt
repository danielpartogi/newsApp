package com.example.core.data.remote

import com.example.core.models.SourceNewsList


interface SourcesRemoteSource {
    suspend fun getSources(category:String): List<SourceNewsList>
}