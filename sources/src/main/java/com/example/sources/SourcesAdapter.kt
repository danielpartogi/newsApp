package com.example.sources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.core.models.SourcesNews
import com.example.sources.databinding.SourceItemBinding


class SourcesAdapter(private val viewModel: SourcesViewModel) :
    RecyclerView.Adapter<SourcesAdapter.SourceViewHolder>() {

    private val users: MutableList<SourcesNews> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SourceViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.source_item, parent, false)
    )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) =
        holder.bindTo(users[position], viewModel)

    // ---

    fun updateData(items: List<SourcesNews>) {
        val diffCallback = SourceDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        users.clear()
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class SourceViewHolder(private val parent: View) : RecyclerView.ViewHolder(parent) {

        private val binding = SourceItemBinding.bind(parent)

        fun bindTo(categoryNews: SourcesNews, viewModel: SourcesViewModel) {
            binding.vm = viewModel
            binding.source = categoryNews
            binding.sourceNameTv.text = categoryNews.name
            binding.sourceDescTv.text = categoryNews.description
        }
    }
}