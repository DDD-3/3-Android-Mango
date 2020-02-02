package com.mango.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mango.domain.entity.DomainEntityShop
import com.mango.presentation.R
import com.mango.presentation.databinding.ItemShopBinding

class HomeAdapter(private val viewModel: HomeViewModel) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var items: List<DomainEntityShop> = emptyList()

    fun submitList(items: List<DomainEntityShop>?) {
        this.items = items.orEmpty()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemShopBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_shop,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            shop = items[position]
            viewModel = this@HomeAdapter.viewModel
        }
    }

    inner class ViewHolder(val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root)

}