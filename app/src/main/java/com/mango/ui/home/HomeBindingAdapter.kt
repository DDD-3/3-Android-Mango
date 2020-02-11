package com.mango.ui.home

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.mango.model.Market

@BindingAdapter(value = ["bind_itmes", "bind_home_viewModel"])
fun RecyclerView.setItems(items: List<Market>?, viewModel: HomeViewModel) {
    HomeAdapter(viewModel).apply {
        addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        this@setItems.adapter = this
        submitList(items)
    }
}