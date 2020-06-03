package com.example.sources.di

import com.example.core.di.CoreComponent
import com.example.sources.SourcesFragment
import dagger.Component

@Component(dependencies = [CoreComponent::class], modules = [SourcesModule::class])
interface SourcesComponent {
    fun inject(sourcesFragment: SourcesFragment)
}