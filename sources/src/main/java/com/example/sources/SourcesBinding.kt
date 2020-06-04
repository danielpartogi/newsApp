package com.example.sources

import android.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.models.SourcesNews


object SourcesBinding {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, data: List<SourcesNews>?) {
        with(recyclerView.adapter as SourcesAdapter) {
            data?.let { updateData(it) }
        }
    }

    @BindingAdapter("app:queryTextListener")
    @JvmStatic
    fun setOnQueryTextListener(
        searchView: SearchView,
        listener: SearchView.OnQueryTextListener?
    ) {
        searchView.setOnQueryTextListener(listener)
    }
}