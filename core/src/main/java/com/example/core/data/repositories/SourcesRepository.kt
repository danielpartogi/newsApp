package com.example.core.data.repositories

import com.example.core.models.CategoryNews
import com.example.core.models.SourceNewsList

interface SourcesRepository {
    suspend fun getSources(category:String): List<SourceNewsList>
}