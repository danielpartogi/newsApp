package com.example.sources

import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.*
import com.example.core.models.ErrorResponse
import com.example.core.models.SourcesNews
import com.example.core.ui.BaseViewModel
import com.example.core.usecases.SourcesUseCase
import com.example.core.utils.Resource
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import java.util.*


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

    private val _sources = MutableLiveData<List<SourcesNews>>()
    val sources: LiveData<List<SourcesNews>> get() = _sources
    val sourcesResponse = MutableLiveData<Resource<SourcesNews>>()


    private val _filteredSources = MutableLiveData<List<SourcesNews>>()
    val filteredSources: LiveData<List<SourcesNews>> get() = _filteredSources


    val query = MutableLiveData("")

    fun getSources() = viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->

        sourcesResponse.postValue(
            Resource(
                Resource.Status.ERROR,
                ErrorResponse(message = throwable.localizedMessage)
            )
        )
    }) {
        val sourcesUseCase = sourcesUseCase(category)
        _sources.postValue(sourcesUseCase)
        _filteredSources.postValue(sourcesUseCase)
        sourcesResponse.postValue(
            Resource(
                Resource.Status.SUCCESS,
                null
            )
        )
    }


    fun sourceClicked(source: SourcesNews) =
        navigate(SourcesFragmentDirections.actionSourceToNews(source.id!!))

    val onQueryTextListeners = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(queryItem: String?): Boolean {
            queryItem?.let {
                query.postValue(it)
            }
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (newText.isNullOrEmpty()) {
                filterSources("")
            }
            return true
        }

    }

    fun filterSources(query: String) {
        _filteredSources.postValue(sources.value?.toMutableList()?.filter {
            it.name?.toLowerCase(Locale.ROOT)?.contains(query.toLowerCase(Locale.ROOT)) ?: false
        })
    }

}