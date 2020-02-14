package com.mango.ui.message

import androidx.lifecycle.liveData
import com.mango.base.BaseViewModel
import com.mango.model.Message
import java.util.*
import javax.inject.Inject

class MessageViewModel @Inject constructor() : BaseViewModel() {

    val items = liveData {
        val messages = mutableListOf<Message>()

        messages.add(Message(0, "", "홍길동", "동해번쩍", Date().time, "홍길동은 동해번쩍"))
        messages.add(Message(1, "", "썬크림", "50++", Date().time, "썬크림썬크림썬크림썬크림썬크림"))
        messages.add(Message(2, "", "네네치킨", "맛있음", Date().time, "교촌치킨교촌치킨교촌치킨교촌치킨교촌치킨"))

        emit(messages)
    }
}