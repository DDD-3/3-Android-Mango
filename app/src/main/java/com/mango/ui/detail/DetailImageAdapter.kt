package com.mango.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mango.databinding.ItemDetailImageBinding

class DetailImageAdapter(
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<String, DetailImageViewHolder>(DetailImageDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailImageViewHolder {
        val binding =
            ItemDetailImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailImageViewHolder(binding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: DetailImageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class DetailImageViewHolder(
    private val binding: ItemDetailImageBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: String) {
        binding.item = item
        binding.lifecycleOwner = lifecycleOwner
        binding.executePendingBindings()
    }
}

val DetailImageDiff = object : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
        return oldItem == newItem
    }

}