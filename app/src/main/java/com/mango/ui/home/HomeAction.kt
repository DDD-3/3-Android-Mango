package com.mango.ui.home

sealed class HomeAction {
    data class ActionDetail(val id: Int) : HomeAction()
}