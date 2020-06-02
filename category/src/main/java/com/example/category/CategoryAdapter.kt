package com.example.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.category.databinding.CellCategoryBinding
import com.example.core.models.CategoryNews


class CategoryAdapter(private val viewModel: CategoryViewModel) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private val users: MutableList<CategoryNews> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.cell_category, parent, false)
    )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bindTo(users[position], viewModel)

    // ---

    fun updateData(items: List<CategoryNews>) {
        val diffCallback = CategoryDiffCallback(users, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        users.clear()
        users.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class CategoryViewHolder(private val parent: View) : RecyclerView.ViewHolder(parent) {

        private val binding = CellCategoryBinding.bind(parent)

        fun bindTo(categoryNews: CategoryNews, viewModel: CategoryViewModel) {



            val id = parent.context.resources.getIdentifier(
                categoryNews.imageStringName,
                "drawable",
                parent.context.packageName
            )
            binding.vm = viewModel
            binding.category = categoryNews
            binding.textview.text = categoryNews.category
            binding.imageview.setImageResource(id)
        }
    }
}