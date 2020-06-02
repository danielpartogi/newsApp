package com.example.core.data.remote

import com.example.core.models.CategoryNews

interface CategoryRemoteSource {
    fun getCategories(): List<CategoryNews>
}