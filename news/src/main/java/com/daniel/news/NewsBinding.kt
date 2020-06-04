package com.daniel.news

import android.widget.SearchView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.daniel.news.di.ArticleAdapter
import com.example.core.models.Article
import com.example.core.models.SourcesNews

object NewsBinding {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, data: List<Article>?) {
        with(recyclerView.adapter as ArticleAdapter) {
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