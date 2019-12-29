package com.mango.domain

import com.mango.domain.entity.DomainEntityDetail
import com.mango.domain.entity.DomainEntityPengpong


interface PengpongRepository {
    suspend fun getList(): List<DomainEntityPengpong>
    suspend fun detail(id: Int): DomainEntityDetail
}
