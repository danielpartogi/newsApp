package com.example.category

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.models.CategoryNews

object CategoryBinding {

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, data: List<CategoryNews>?) {
        Log.d("datanewss", data.toString())
        with(recyclerView.adapter as CategoryAdapter) {
            data?.let { updateData(it) }
        }
    }
}