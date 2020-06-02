package com.example.core.usecases

import com.example.core.data.repositories.CategoryRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {
    operator fun invoke() = categoryRepository.getCategories()
}