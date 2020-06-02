package com.example.category

import androidx.recyclerview.widget.DiffUtil
import com.example.core.models.CategoryNews

class CategoryDiffCallback(private val oldList: List<CategoryNews>,
                           private val newList: List<CategoryNews>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].category == newList[newItemPosition].category
                && oldList[oldItemPosition].imageStringName == newList[newItemPosition].imageStringName
    }
}