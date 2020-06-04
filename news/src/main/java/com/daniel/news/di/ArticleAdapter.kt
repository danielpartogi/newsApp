package com.daniel.news.di

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.daniel.news.ArticleDiffCallback
import com.daniel.news.NewsListViewModel
import com.daniel.news.R
import com.daniel.news.databinding.ArticleItemBinding
import com.example.core.models.Article

class ArticleAdapter(private val viewModel: NewsListViewModel) :
    RecyclerView.Adapter<ArticleAdapter.SourceViewHolder>() {

    private val users: MutableList<Article> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SourceViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
    )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) =
        holder.bindTo(users[position], viewModel)

    // ---

    fun updateData(items: List<Article>) {
        val diffCallback = ArticleDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        users.clear()
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    fun addData(items: List<Article>) {
        val diffCallback = ArticleDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class SourceViewHolder(private val parent: View) : RecyclerView.ViewHolder(parent) {

        private val binding = ArticleItemBinding.bind(parent)

        fun bindTo(categoryNews: Article, viewModel: NewsListViewModel) {
            binding.vm = viewModel
            binding.article = categoryNews
        }
    }
}