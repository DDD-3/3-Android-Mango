package com.mango.di.module

import com.mango.data.ShopRepositoryImpl
import com.mango.data.ShopService
import com.mango.data.mapper.ShopMapper
import com.mango.domain.ShopRepository
import dagger.Module
import dagger.Provides

@Module(includes = [MapperModule::class])
class RepositoryModule {

    //Example
    @Provides
    fun provideShopRepository(
        shopService: ShopService,
        shopMapper: ShopMapper
    ): ShopRepository {
        return ShopRepositoryImpl(shopService, shopMapper)
    }

}

@Module
class MapperModule {
    //Example
    @Provides
    fun provideShopMapper(): ShopMapper {
        return ShopMapper()
    }

}