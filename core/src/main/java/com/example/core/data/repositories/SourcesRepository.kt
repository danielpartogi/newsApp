package com.example.core.data.repositories

import com.example.core.models.SourcesNews

interface SourcesRepository {
    suspend fun getSources(category:String): List<SourcesNews>?
}