package com.example.core.di

import com.example.core.data.remote.SourcesRemoteSource
import com.example.core.data.remote.SourcesRemoteSourceImpl
import com.example.core.data.repositories.SourcesRepository
import com.example.core.data.repositories.SourcesRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class SourcesModule {
    @Binds
    abstract fun provideCategoryRepository(sourcesRepositoryImpl: SourcesRepositoryImpl): SourcesRepository

    @Binds
    abstract fun provideCategoryRemoteSource(sourcesRemoteSourceImpl: SourcesRemoteSourceImpl): SourcesRemoteSource
}