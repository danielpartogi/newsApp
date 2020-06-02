package com.example.core.data.repositories

interface CategoryRepository {
    fun getCategories(): List<String>
}