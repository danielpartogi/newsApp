package com.example.core.data.repositories

import com.example.core.models.CategoryNews

interface CategoryRepository {
    fun getCategories(): List<CategoryNews>
}