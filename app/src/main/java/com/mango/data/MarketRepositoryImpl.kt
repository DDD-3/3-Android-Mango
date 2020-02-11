package com.mango.data

import com.mango.model.Market

interface MarketRepository {
    suspend fun getList(): List<Market>
    suspend fun detail(id: Int): Market
}

class MarketRepositoryImpl constructor(
    private val marketService: MarketService
) : MarketRepository {

    override suspend fun getList(): List<Market>  = marketService.getList()

    override suspend fun detail(id: Int) = marketService.detail(id)
}
