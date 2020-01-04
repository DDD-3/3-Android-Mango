package com.mango.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.mango.domain.ShopUseCase
import com.mango.presentation.base.BaseViewModel
import com.mango.presentation.util.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor(
    shopUseCase: ShopUseCase
) : BaseViewModel() {

    init {
        shopUseCase.invoke(viewModelScope, ShopUseCase.Params(1), {

        }, {

        })

    }

    private val _clickToDetail = SingleLiveEvent<MainAction.ActionDetail>()
    val clickToDetail: LiveData<MainAction.ActionDetail>
        get() = _clickToDetail

    fun moveToDetail() {
        _clickToDetail.value = MainAction.ActionDetail(1)
    }
}