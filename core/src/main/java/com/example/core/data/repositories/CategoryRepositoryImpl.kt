package com.example.core.data.repositories

import com.example.core.data.remote.CategoryRemoteSource
import com.example.core.models.CategoryNews
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteSource: CategoryRemoteSource
) : CategoryRepository {
    override fun getCategories(): List<CategoryNews> {
        return remoteSource.getCategories()
    }
}