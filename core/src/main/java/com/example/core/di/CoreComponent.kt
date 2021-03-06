package com.example.core.di

import com.example.core.data.remote.CategoryRemoteSource
import com.example.core.data.remote.NewsRemoteSource
import com.example.core.data.remote.SourcesRemoteSource
import com.example.core.data.repositories.CategoryRepository
import com.example.core.data.repositories.NewsRepository
import com.example.core.data.repositories.SourcesRepository
import dagger.Component

@Component(modules = [CategoryModule::class, SourcesCoreModule::class, NewsModule::class])
interface CoreComponent {
    fun provideCategoryRepository(): CategoryRepository
    fun provideCategoryRemoteSource(): CategoryRemoteSource
    fun provideSourcesRepository(): SourcesRepository
    fun provideSourcesRemoteSource(): SourcesRemoteSource
    fun provideNewsRepository(): NewsRepository
    fun provideNewsRemoteSource(): NewsRemoteSource
}