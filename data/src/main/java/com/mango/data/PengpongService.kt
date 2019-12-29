package com.mango.data

import com.mango.data.entitiy.DataEntityDetail
import com.mango.data.entitiy.DataEntityPengpong
import retrofit2.http.GET
import retrofit2.http.Path

interface PengpongService {

    @GET("dummy")
    suspend fun getList(): List<DataEntityPengpong>

    @GET("dummy/{id}")
    suspend fun detail(@Path("id") id: Int): DataEntityDetail

}