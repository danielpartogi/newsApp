package com.daniel.news

import androidx.recyclerview.widget.DiffUtil
import com.example.core.models.Article
import com.example.core.models.SourcesNews

class ArticleDiffCallback(
    private val oldList: List<Article>,
    private val newList: List<Article>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].title == newList[newItemPosition].title &&
                oldList[oldItemPosition].source == newList[newItemPosition].source &&
                oldList[oldItemPosition].urlToImage == newList[newItemPosition].urlToImage

    }
}