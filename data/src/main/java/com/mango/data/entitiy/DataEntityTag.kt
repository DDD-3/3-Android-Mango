package com.mango.data.entitiy

import com.google.gson.annotations.SerializedName

data class DataEntityTag(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String?
)