package com.mango.presentation.home

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.mango.domain.entity.DomainEntityShop

@BindingAdapter(value = ["bind_itmes", "bind_home_viewModel"])
fun RecyclerView.setItems(items: List<DomainEntityShop>?, viewModel: HomeViewModel) {
    HomeAdapter(viewModel).apply {
        addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        this@setItems.adapter = this
        submitList(items)
    }
}