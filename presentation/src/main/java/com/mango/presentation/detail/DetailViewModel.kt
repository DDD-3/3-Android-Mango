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
}