package com.example.sources

import android.util.Log
import androidx.lifecycle.*
import com.example.core.models.CategoryNews
import com.example.core.models.SourceNewsList
import com.example.core.ui.BaseViewModel
import com.example.core.usecases.SourcesUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class SourcesViewModel(
    private val sourcesUseCase: SourcesUseCase,
    private val category: String
) :
    BaseViewModel() {

    class Factory(
        private val sourcesUseCase: SourcesUseCase,
        private val category: String
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SourcesViewModel::class.java)) {
                return SourcesViewModel(sourcesUseCase, category) as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }

    private val _sources = MutableLiveData<SourceNewsList>()
    val sources: LiveData<SourceNewsList> get() = _sources

    fun getSources() = viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
    }) {
        val sourcesUseCase = sourcesUseCase(category)
        _sources.postValue(sourcesUseCase)
        Log.d("data", sources.toString())
    }


}