package com.mango.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mango.base.BaseViewModel
import com.mango.data.MarketRepository
import com.mango.model.Market
import com.mango.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repository: MarketRepository
) : BaseViewModel() {

    private val _errorToast = SingleLiveEvent<String>()
    val errorToast: LiveData<String>
        get() = _errorToast

    private val _detail = MutableLiveData<Market>()
    val detail: LiveData<Market>
        get() = _detail

    private val _clickToBack = SingleLiveEvent<Any>()
    val clickToBack: LiveData<Any>
        get() = _clickToBack

    private val _clickToShare = SingleLiveEvent<Any>()
    val clickToShare: LiveData<Any>
        get() = _clickToShare

    fun bindDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val item = repository.detail(id)
            launch(Dispatchers.Main) {
                _detail.value = item
            }
        }
    }

    fun clickToBack() {
        _clickToBack.call()
    }

    fun clickToShare() {
        _clickToShare.call()
    }
}