package com.example.category

import androidx.lifecycle.*
import com.example.core.usecases.CategoryUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryUseCase: CategoryUseCase) : ViewModel(){
    class Factory(
        private val categoryUseCase: CategoryUseCase
    ) : ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
                return CategoryViewModel(categoryUseCase) as T
            }
            throw IllegalArgumentException("ViewModel not found")
        }
    }


    private val _category = MutableLiveData<List<String>>()
    val category: LiveData<List<String>> = _category

    init {

        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
        }) {
            val categories = categoryUseCase()
            _category.postValue(categories)
        }
    }
}