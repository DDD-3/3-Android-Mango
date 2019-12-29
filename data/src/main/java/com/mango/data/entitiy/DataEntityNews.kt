package com.mango.data.entitiy

import com.google.gson.annotations.SerializedName

data class DataEntityNews(
    @SerializedName("id") val id: Int,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("url") val link: String?
)