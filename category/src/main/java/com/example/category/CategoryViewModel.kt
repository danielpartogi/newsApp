package com.example.category

import android.util.Log
import androidx.lifecycle.*
import com.example.core.models.CategoryNews
import com.example.core.ui.BaseViewModel
import com.example.core.usecases.CategoryUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class CategoryViewModel(private val categoryUseCase: CategoryUseCase) : BaseViewModel(){
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


    private val _categories = MutableLiveData<List<CategoryNews>>()
    val categories: LiveData<List<CategoryNews>> get() = _categories

    fun getCategories() = viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
    }) {
        val categories = categoryUseCase()
        _categories.postValue(categories)
        Log.d("data", categories.toString())
    }

    fun onClickCategory(category: CategoryNews)
            = navigate(CategoryListFragmentDirections.actionCategoryToSources())

}