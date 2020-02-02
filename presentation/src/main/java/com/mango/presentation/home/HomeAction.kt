package com.mango.presentation.home

sealed class HomeAction {
    data class ActionDetail(val id: Int) : HomeAction()
}