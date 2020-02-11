package com.mango.ui.home

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mango.model.Market

@BindingAdapter("bind_home_items")
fun RecyclerView.setItems(items: List<Market>?) {
    items?.let {
        (adapter as HomeAdapter).submitList(it)
    }
}