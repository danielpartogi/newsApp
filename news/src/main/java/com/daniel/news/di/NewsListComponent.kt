package com.daniel.news.di

import com.daniel.news.NewsListFragment
import com.example.core.di.CoreComponent
import dagger.Component


@Component(dependencies = [CoreComponent::class], modules = [NewsListModule::class])
interface NewsComponent {
    fun inject(newsListFragment: NewsListFragment)
}