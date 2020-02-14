package com.mango.model

data class Message(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val location: String,
    val time: Long,
    val content: String
)