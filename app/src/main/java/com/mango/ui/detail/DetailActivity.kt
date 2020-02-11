package com.mango.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.BindingAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.mango.common.createViewModel
import com.mango.R
import com.mango.base.BaseActivity
import com.mango.databinding.ActivityDetailBinding
import com.mango.model.Tag
import com.mango.util.MarginItemDecoration
import com.mango.util.toast
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

        binding.detailRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = DetailImageAdapter(this@DetailActivity)
            setHasFixedSize(true)
        }

        binding.layoutDetailContent.detailTagList.apply {
            layoutManager =
                LinearLayoutManager(this@DetailActivity, LinearLayoutManager.HORIZONTAL, false)
            adapter = DetailTagAdapter(this@DetailActivity)
            addItemDecoration(MarginItemDecoration(this@DetailActivity))
        }

        LinearSnapHelper().attachToRecyclerView(binding.detailRecyclerView)

        BottomSheetBehavior.from(binding.layoutDetailContent.detailBottomSheetContainer)
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

@BindingAdapter("bind_detail_image")
fun RecyclerView.bindDetailImage(items: List<String>?) {
    items?.let {
        (adapter as DetailImageAdapter).submitList(it)
    }
}

@BindingAdapter("bind_detail_tag")
fun RecyclerView.bindDetailTags(items: List<Tag>?) {
    items?.let {
        (adapter as DetailTagAdapter).submitList(it)
    }
}