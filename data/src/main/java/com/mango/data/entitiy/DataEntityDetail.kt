package com.mango.data.entitiy

import com.google.gson.annotations.SerializedName

data class DataEntityDetail(
    @SerializedName("id") val id: Int,
    @SerializedName("profileImage") val backgroundUrl: String?,
    @SerializedName("tel") val tel: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("address") val address: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("tag") val tags: List<DataEntityTag>?,
    @SerializedName("news") val news: List<DataEntityNews>?
)