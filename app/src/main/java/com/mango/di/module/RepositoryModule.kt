package com.mango.di.module

import com.mango.data.MarketRepository
import com.mango.data.MarketRepositoryImpl
import com.mango.data.MarketService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    //Example
    @Provides
    fun provideShopRepository(
        marketService: MarketService
    ): MarketRepository {
        return MarketRepositoryImpl(marketService)
    }
}