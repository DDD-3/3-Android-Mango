package com.mango.data

import com.mango.data.entitiy.DataEntityPengpong
import retrofit2.http.GET

interface PengpongService {

    @GET("dummy")
    suspend fun getList(): List<DataEntityPengpong>

}