package com.mango.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mango.domain.ShopUseCase
import com.mango.domain.entity.DomainEntityShop
import com.mango.presentation.base.BaseViewModel
import com.mango.presentation.main.MainAction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    shopUseCase: ShopUseCase
) : BaseViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _shop = MutableLiveData<List<DomainEntityShop>>()
    val shop: LiveData<List<DomainEntityShop>>
        get() = _shop

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

    private val _clickToDetail = MutableLiveData<HomeAction.ActionDetail>()
    val clickToDetail: LiveData<HomeAction.ActionDetail>
        get() = _clickToDetail

    init {
        shopUseCase.execute(viewModelScope, {
            _shop.value = it
        }, {
            _error.value = it
        })
    }

    fun moveToDetail(id: Int) {
        _clickToDetail.value = HomeAction.ActionDetail(id)
    }


}