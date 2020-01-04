package com.mango.data

import com.mango.data.mapper.ShopMapper
import com.mango.data.mapper.toDomainEntityDetail
import com.mango.domain.ShopRepository
import com.mango.domain.entity.DomainEntityDetail
import com.mango.domain.entity.DomainEntityShop


//Example

class ShopRepositoryImpl constructor(
    private val shopService: ShopService,
    private val shopMapper: ShopMapper
) : ShopRepository {

    override suspend fun getList(): List<DomainEntityShop> {
        return shopMapper.mapFromEntity(
            shopService.getList()
        )
    }

    override suspend fun detail(id: Int): DomainEntityDetail {
        return shopService.detail(id).toDomainEntityDetail()
    }
}
