package com.mango.data

import com.mango.model.Market
import retrofit2.http.GET
import retrofit2.http.Path

interface MarketService {

    @GET("market")
    suspend fun getList(): List<Market>

    @GET("market/{id}")
    suspend fun detail(@Path("id") id: Int): Market

}