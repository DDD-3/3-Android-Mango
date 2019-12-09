package com.mango.presentation.main

import androidx.lifecycle.LiveData
import com.mango.presentation.base.BaseViewModel
import com.mango.presentation.util.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    private val _clickToDetail = SingleLiveEvent<Any>()
    val clickToDetail: LiveData<Any>
        get() = _clickToDetail

    fun moveToDetail() {
        _clickToDetail.call()
    }
}