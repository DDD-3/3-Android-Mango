package com.mango.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["bind_image"])
fun ImageView.setImage(url: String?) {

    Glide.with(this)
        .load(url)
        .into(this)

}
