package com.mango.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mango.domain.PengpongUseCase
import com.mango.presentation.base.BaseViewModel
import com.mango.presentation.util.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor(
    pengpongUseCase: PengpongUseCase
) : BaseViewModel() {

    init {
        pengpongUseCase.invoke(viewModelScope, PengpongUseCase.Params(1), {

        }, {

        })

    }

    private val _clickToDetail = SingleLiveEvent<Any>()
    val clickToDetail: LiveData<Any>
        get() = _clickToDetail

    fun moveToDetail() {
        _clickToDetail.call()
    }
}