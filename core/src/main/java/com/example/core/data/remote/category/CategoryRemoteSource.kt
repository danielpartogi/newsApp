package com.example.core.data.remote.category

interface CategoryRemoteSource {
    fun getCategories(): List<String>
}