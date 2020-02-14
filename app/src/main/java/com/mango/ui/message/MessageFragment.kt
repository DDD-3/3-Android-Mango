package com.mango.ui.message

import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.databinding.FragmentMessageBinding
import com.mango.model.Message
import com.mango.util.MarginItemDecoration
import javax.inject.Inject

class MessageFragment : BaseFragment<FragmentMessageBinding>(R.layout.fragment_message) {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: MessageViewModel by lazy {
        createViewModel(factory, MessageViewModel::class.java)
    }

    override fun initView() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.messageRecyclerView.apply {
            setHasFixedSize(true)
            adapter = MessageAdapter(viewLifecycleOwner)
            addItemDecoration(MarginItemDecoration(requireContext()))
        }
    }
}

@BindingAdapter("submit_message")
fun submitMessage(recyclerView: RecyclerView, items: List<Message>?) {
    items?.let {
        (recyclerView.adapter as MessageAdapter).submitList(it)
    }
}