package com.mango.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.mango.R

@BindingAdapter(value = ["bind_image"])
fun ImageView.setImage(url: String?) {
    url?.let {
        println(it)
        Glide.with(this.context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("category_image")
fun bindCategoryImage(imageView: ImageView, id: Int?) {
    id?.let {
        val resource = when (it) {
            0 -> R.mipmap.ic_restaurant_foreground
            1 -> R.mipmap.ic_cafe_foreground
            2 -> R.mipmap.ic_hair_foreground
            3 -> R.mipmap.ic_fruit_foreground
            4 -> R.mipmap.ic_hospital_foreground
            5 -> R.mipmap.ic_exercise_foreground
            6 -> R.mipmap.ic_game_foreground
            7 -> R.mipmap.ic_fun_foreground
            else -> 0
        }

        Glide.with(imageView.context)
            .load(resource)
            .into(imageView)
    }
}
