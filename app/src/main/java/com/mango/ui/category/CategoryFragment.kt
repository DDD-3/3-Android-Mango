package com.mango.ui.category

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModelProvider
import com.mango.R
import com.mango.base.BaseFragment
import com.mango.common.createViewModel
import com.mango.databinding.FragmentCategoryBinding
import javax.inject.Inject

class CategoryFragment() : BaseFragment<FragmentCategoryBinding>(R.layout.fragment_category),
    Parcelable {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel: CategoryViewModel by lazy {
        createViewModel(factory, CategoryViewModel::class.java)
    }

    constructor(parcel: Parcel) : this() {

    }

    override fun initView() {
        binding.apply {
            viewModel = this@CategoryFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CategoryFragment> {
        override fun createFromParcel(parcel: Parcel): CategoryFragment {
            return CategoryFragment(parcel)
        }

        override fun newArray(size: Int): Array<CategoryFragment?> {
            return arrayOfNulls(size)
        }
    }

}