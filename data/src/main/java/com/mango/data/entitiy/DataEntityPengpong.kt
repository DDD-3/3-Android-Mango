package com.mango.data.entitiy

data class DataEntityPengpong(
    val items : List<Item>
)

data class Item(
    val address: String,
    val description: String,
    val id: Int,
    val profileImage: Any,
    val tel: String,
    val title: String
)