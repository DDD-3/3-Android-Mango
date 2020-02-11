package com.mango.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mango.base.BaseViewModel
import com.mango.data.MarketRepository
import com.mango.model.Market
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    repository: MarketRepository
) : BaseViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _shop = MutableLiveData<List<Market>>()
    val shop: LiveData<List<Market>>
        get() = _shop

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable>
        get() = _error

    private val _clickToDetail = MutableLiveData<HomeAction.ActionDetail>()
    val clickToDetail: LiveData<HomeAction.ActionDetail>
        get() = _clickToDetail

    init {
        viewModelScope.launch(Dispatchers.IO){
            val items = repository.getList()
            launch(Dispatchers.Main) {
                _shop.value = items
            }
        }
    }

    fun moveToDetail(id: Int) {
        _clickToDetail.value = HomeAction.ActionDetail(id)
    }


}