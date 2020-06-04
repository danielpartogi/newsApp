package com.daniel.news.di

import com.daniel.news.NewsListViewModel
import com.example.core.usecases.NewsUseCase
import dagger.Module
import dagger.Provides

@Module
class NewsListModule(private val source: String) {
    @Provides
    fun providesNewsViewModelFactory(
        getNewsUseCase: NewsUseCase
    ) = NewsListViewModel.Factory(source, getNewsUseCase)
}