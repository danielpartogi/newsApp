package com.example.core.data.remote.category

import retrofit2.HttpException
import javax.inject.Inject

class CategoryRemoteSourceImpl @Inject constructor() :
    CategoryRemoteSource {
    override fun getCategories(): List<String> {
        return listOf(
            "business",
            "entertainment",
            "general",
            "health",
            "science",
            "sports",
            "technology"
        )
    }

}