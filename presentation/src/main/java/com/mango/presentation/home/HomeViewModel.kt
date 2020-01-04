package com.mango.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mango.domain.entity.DomainEntityShop
import com.mango.presentation.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel() {


    private val _shop = MutableLiveData<DomainEntityShop>()
    val shop: LiveData<DomainEntityShop>
        get() = _shop

}