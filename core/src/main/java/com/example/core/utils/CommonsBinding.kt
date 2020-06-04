package com.example.core.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.core.R

object CommonsBinding {
    @BindingAdapter("image","placeholder")
    @JvmStatic
    fun setImage(image: ImageView, url: String?, placeHolder: Drawable) {

        if (!url.isNullOrEmpty()){

            Glide.with(image.context).load(url).centerCrop()
                .placeholder(R.drawable.placeholder)
                .into(image)
        }
        else{
            image.setImageDrawable(placeHolder)
        }


    }
}