package com.example.core.di

import com.example.core.data.remote.CategoryRemoteSource
import com.example.core.data.remote.CategoryRemoteSourceImpl
import com.example.core.data.repositories.CategoryRepository
import com.example.core.data.repositories.CategoryRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CategoryModule {
    @Binds
    abstract fun provideCategoryRepository(categoryRepositoryImpl: CategoryRepositoryImpl): CategoryRepository

    @Binds
    abstract fun provideCategoryRemoteSource(categoryRemoteSourceImpl: CategoryRemoteSourceImpl): CategoryRemoteSource
}