package com.mango.presentation.main

sealed class MainAction {
    data class ActionDetail(val id: Int) : MainAction()
}