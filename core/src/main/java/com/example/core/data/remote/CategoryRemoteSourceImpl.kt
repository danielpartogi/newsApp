package com.example.core.data.remote

import com.example.core.models.CategoryNews
import javax.inject.Inject

class CategoryRemoteSourceImpl @Inject constructor() :
    CategoryRemoteSource {
    override fun getCategories(): List<CategoryNews> {
        return listOf(
            CategoryNews("ic_work", "business"),
            CategoryNews("ic_entertain", "entertainment"),
            CategoryNews("ic_general", "general"),
            CategoryNews("ic_health", "health"),
            CategoryNews("ic_science", "science"),
            CategoryNews("ic_sports", "sports"),
            CategoryNews("ic_tech", "technology")
        )
    }

}