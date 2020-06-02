package com.example.core.di

import com.example.core.data.remote.category.CategoryRemoteSource
import com.example.core.data.repositories.CategoryRepository
import dagger.Component

@Component(modules = [CategoryModule::class])
interface CoreComponent {
    fun provideCategoryRepository(): CategoryRepository
    fun provideCategoryRemoteSource(): CategoryRemoteSource
}