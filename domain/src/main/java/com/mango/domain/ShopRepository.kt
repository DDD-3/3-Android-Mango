package com.mango.domain

import com.mango.domain.entity.DomainEntityDetail
import com.mango.domain.entity.DomainEntityShop


interface ShopRepository {
    suspend fun getList(): List<DomainEntityShop>
    suspend fun detail(id: Int): DomainEntityDetail
}
