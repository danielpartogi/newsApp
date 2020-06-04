package com.daniel.news

import androidx.lifecycle.*
import com.example.core.models.Article
import com.example.core.models.ErrorResponse
import com.example.core.models.SourcesNews
import com.example.core.ui.BaseViewModel
import com.example.core.usecases.NewsUseCase
import com.example.core.usecases.SourcesUseCase
import com.example.core.utils.Resource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class NewsListViewModel(
    private val source: String,
    private val newsUseCase: NewsUseCase
) : BaseViewModel() {
    class Factory(
        private val source: String,
        private val newsUseCase: NewsUseCase
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
                return NewsListViewModel(source,newsUseCase) as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _articles
    val articleResponse = MutableLiveData<Resource<List<Article>>>()

    val query = MutableLiveData<String>("")

    fun getArticles() = viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->

        articleResponse.postValue(
            Resource(
                Resource.Status.ERROR,
                ErrorResponse(message = throwable.localizedMessage)
            )
        )
    }) {
        val sourcesUseCase = newsUseCase(query.value!!, source)
        _articles.postValue(sourcesUseCase)
        _articles.postValue(sourcesUseCase)
        articleResponse.postValue(
            Resource(
                Resource.Status.SUCCESS,
                null
            )
        )
    }
}