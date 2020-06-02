package com.example.category.di

import com.example.category.CategoryListFragment
import com.example.core.di.CoreComponent
import dagger.Component

@Component(dependencies = [CoreComponent::class], modules = [CategoriesModule::class])
interface CategoryComponent {
    fun inject(categoryListFragment: CategoryListFragment)
}