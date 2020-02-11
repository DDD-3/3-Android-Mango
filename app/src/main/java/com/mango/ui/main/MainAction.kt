package com.mango.ui.main

sealed class MainAction {
    data class ActionDetail(val id: Int) : MainAction()
}