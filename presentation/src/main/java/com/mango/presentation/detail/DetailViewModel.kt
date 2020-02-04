package com.mango.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mango.domain.DetailUseCase
import com.mango.domain.entity.DomainEntityDetail
import com.mango.presentation.base.BaseViewModel
import com.mango.presentation.util.SingleLiveEvent
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val useCase: DetailUseCase
) : BaseViewModel() {

    private val _errorToast = SingleLiveEvent<String>()
    val errorToast: LiveData<String>
        get() = _errorToast

    private val _detail = MutableLiveData<DomainEntityDetail>()
    val detail: LiveData<DomainEntityDetail>
        get() = _detail

    private val _clickToBack = SingleLiveEvent<Any>()
    val clickToBack: LiveData<Any>
        get() = _clickToBack

    private val _clickToShare = SingleLiveEvent<Any>()
    val clickToShare: LiveData<Any>
        get() = _clickToShare

    private val _detailImage = MutableLiveData<String>()
    val detailImage: LiveData<String>
        get() = _detailImage

    init {
        _detailImage.value =
            "https://cdn.crowdpic.net/detail-thumb/thumb_d_A175A8EE60E76F315D7C02F85C3B5D01.jpg"
    }

    fun bindDetail(id: Int) {
        useCase.invoke(viewModelScope, DetailUseCase.Params(id), {
            _detail.postValue(it)
        }, {
            _errorToast.postValue("Error, Retry..")
        })
    }

    fun clickToBack() {
        _clickToBack.call()
    }

    fun clickToShare() {
        _clickToShare.call()
    }
}