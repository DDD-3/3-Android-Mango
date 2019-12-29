package com.mango.presentation.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mango.common.createViewModel
import com.mango.presentation.R
import com.mango.presentation.base.BaseActivity
import com.mango.presentation.databinding.ActivityDetailBinding
import com.mango.presentation.util.toast
import javax.inject.Inject

class DetailActivity : BaseActivity<ActivityDetailBinding>(R.layout.activity_detail) {

    companion object {

        private const val EXTRA_ID = "extra_id"

        fun starterDetailById(context: Context, id: Int) {
            context.startActivity(
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(EXTRA_ID, id)
                }
            )
        }
    }

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: DetailViewModel by lazy {
        createViewModel(factory, DetailViewModel::class.java)
    }

    private val detailId by lazy {
        intent.getIntExtra(EXTRA_ID, 0)
    }

    override fun initView() {
        binding.apply {
            viewModel = this@DetailActivity.viewModel
            lifecycleOwner = this@DetailActivity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.bindDetail(detailId)

        viewModel.errorToast.observe(this, Observer {
            toast(it)
        })

        viewModel.clickToBack.observe(this, Observer {
            finish()
        })
    }
}