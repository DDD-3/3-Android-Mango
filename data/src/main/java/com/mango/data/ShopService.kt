package com.mango.data

import com.mango.data.entitiy.DataEntityDetail
import com.mango.data.entitiy.DataEntityShop
import retrofit2.http.GET
import retrofit2.http.Path

interface ShopService {

    @GET("dummy")
    suspend fun getList(): List<DataEntityShop>

    @GET("dummy/{id}")
    suspend fun detail(@Path("id") id: Int): DataEntityDetail

}