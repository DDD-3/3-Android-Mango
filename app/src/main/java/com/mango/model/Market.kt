package com.mango.model

import com.google.gson.annotations.SerializedName

data class Market(
    @SerializedName("id")
    val id: Int,
    @SerializedName("thumbs")
    val thumbs: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("desc")
    val desc : String,
    @SerializedName("salesTime")
    val salesTime: String,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("state")
    val state: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("majorDistrict")
    val majorDistrict: String?,
    @SerializedName("minorDistrict")
    val minorDistrict: String?,
    @SerializedName("address")
    val address: String,
    @SerializedName("categories")
    val categories: List<Category>,
    @SerializedName("tags")
    val tags: List<Tag>
)