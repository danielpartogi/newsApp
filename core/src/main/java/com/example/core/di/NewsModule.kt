package com.example.core.di

import com.example.core.data.remote.NewsRemoteSource
import com.example.core.data.remote.NewsRemoteSourceImpl
import com.example.core.data.repositories.NewsRepository
import com.example.core.data.repositories.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class NewsModule {
    @Binds
    abstract fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

    @Binds
    abstract fun provideNewsRemoteSource(newsRemoteSourceImpl: NewsRemoteSourceImpl): NewsRemoteSource
}