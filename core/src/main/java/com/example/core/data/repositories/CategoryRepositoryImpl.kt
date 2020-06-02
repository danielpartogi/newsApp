package com.example.core.data.repositories

import com.example.core.data.remote.category.CategoryRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteSource: CategoryRemoteSource
) : CategoryRepository {
    override fun getCategories(): List<String> {
        return remoteSource.getCategories()
    }
}