package com.example.core.usecases

import com.example.core.data.repositories.NewsRepository
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(query: String, page:Int, source: String) =
        newsRepository.getNews(query,page, source)
}