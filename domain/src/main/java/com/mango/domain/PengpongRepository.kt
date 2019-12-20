package com.mango.domain

import com.mango.domain.entity.DomainEntityPengpong


//Example
interface PengpongRepository {
    suspend fun getList() : List<DomainEntityPengpong>

}
