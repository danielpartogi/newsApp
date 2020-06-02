package com.example.category.di

import com.example.category.CategoryViewModel
import com.example.core.usecases.CategoryUseCase
import dagger.Module
import dagger.Provides

@Module
class CategoriesModule() {
    @Provides
    fun provideCharacterDetailsViewModelFactory(
        getCharacter: CategoryUseCase
    ) = CategoryViewModel.Factory(getCharacter)
}
