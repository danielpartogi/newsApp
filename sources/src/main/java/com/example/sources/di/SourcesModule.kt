package com.example.sources.di

import com.example.core.usecases.SourcesUseCase
import com.example.sources.SourcesViewModel
import dagger.Module
import dagger.Provides

@Module
class SourcesModule(private val category: String) {
    @Provides
    fun providesSourcesViewModelFactory(
        getSources: SourcesUseCase
    ) = SourcesViewModel.Factory(getSources, category)
}
