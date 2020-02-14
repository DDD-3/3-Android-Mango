package com.mango.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mango.databinding.ItemCategoryBinding
import com.mango.model.Category

class CategoryAdapter(
    private val lifecycleOwner: LifecycleOwner
) : ListAdapter<Category, CategoryViewHolder>(CategoryDiff) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class CategoryViewHolder(
    private val binding: ItemCategoryBinding,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Category) {
        binding.item = item
        binding.lifecycleOwner = lifecycleOwner
        binding.executePendingBindings()
    }
}

val CategoryDiff = object : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.name == newItem.name
    }

}