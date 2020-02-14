package com.mango.ui.message

import androidx.lifecycle.ViewModelProvider
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.databinding.FragmentMessageBinding
import javax.inject.Inject

class MessageFragment : BaseFragment<FragmentMessageBinding>(R.layout.fragment_message){

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel : MessageViewModel by lazy {
        createViewModel(factory, MessageViewModel::class.java)
    }

    override fun initView() {

    }

}