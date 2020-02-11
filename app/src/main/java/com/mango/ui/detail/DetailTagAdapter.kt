package com.mango.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mango.databinding.ItemDetailTagBinding
import com.mango.model.Tag

class DetailTagAdapter(
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Tag, DetailTagViewHolder>(DetailTagDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailTagViewHolder {
        val binding =
            ItemDetailTagBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailTagViewHolder(binding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: DetailTagViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class DetailTagViewHolder(
    private val binding: ItemDetailTagBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Tag) {
        binding.item = item
        binding.lifecycleOwner = lifecycleOwner
        binding.executePendingBindings()
    }
}

val DetailTagDiff = object : DiffUtil.ItemCallback<Tag>() {
    override fun areItemsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tag, newItem: Tag): Boolean {
        return oldItem.name == newItem.name
    }

}