package com.example.core.data.repositories

import com.example.core.data.remote.SourcesRemoteSource
import com.example.core.models.SourcesNews
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(
    private val remoteSource: SourcesRemoteSource
) : SourcesRepository {
    override suspend fun getSources(category:String): List<SourcesNews>? {
        return remoteSource.getSources(category).sources
    }
}