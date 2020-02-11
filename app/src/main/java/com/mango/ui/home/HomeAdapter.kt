package com.mango.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mango.R
import com.mango.databinding.ItemHomeBinding
import com.mango.model.Market

class HomeAdapter(
    private val viewModel: HomeViewModel,
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Market, HomeAdapter.ViewHolder>(HomeDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemHomeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_home,
            parent,
            false
        )
        return ViewHolder(binding, viewModel, lifecycleOwner)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHomeBinding,
        private val viewModel: HomeViewModel,
        private val lifecycleOwner: LifecycleOwner
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Market) {
            binding.item = item
            binding.viewModel = viewModel
            binding.lifecycleOwner = lifecycleOwner
            binding.executePendingBindings()
        }
    }
}

val HomeDiff = object : DiffUtil.ItemCallback<Market>() {
    override fun areItemsTheSame(oldItem: Market, newItem: Market): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Market, newItem: Market): Boolean {
        return oldItem == newItem
    }

}