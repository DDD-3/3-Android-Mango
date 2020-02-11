package com.mango.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mango.R
import com.mango.databinding.ItemShopBinding
import com.mango.model.Market

class HomeAdapter(private val viewModel: HomeViewModel) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    private var items: List<Market> = emptyList()

    fun submitList(items: List<Market>?) {
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
            item = items[position]
            viewModel = this@HomeAdapter.viewModel
        }
    }

    inner class ViewHolder(val binding: ItemShopBinding) : RecyclerView.ViewHolder(binding.root)

}