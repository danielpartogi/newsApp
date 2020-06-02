package com.example.core.usecases

import com.example.core.data.repositories.SourcesRepository
import javax.inject.Inject

class SourcesUseCase @Inject constructor(
    private val sourcesRepository: SourcesRepository
) {
    suspend operator fun invoke(category: String) = sourcesRepository.getSources(category)
}