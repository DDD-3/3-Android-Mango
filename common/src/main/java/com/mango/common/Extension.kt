package com.mango.common

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*

fun <T : ViewModel> AppCompatActivity.createViewModel(
    factory: ViewModelProvider.Factory, classType: Class<T>
): T = ViewModelProviders.of(this, factory)[classType]

fun <T : ViewModel> Fragment.createViewModel(
    factory: ViewModelProvider.Factory, classType: Class<T>
): T = ViewModelProviders.of(this, factory)[classType]


inline fun <T> LifecycleOwner.observer(liveData: LiveData<T>, crossinline action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { t -> action(t) } })
}