package com.mango.data

import com.mango.data.mapper.PengpongMapper
import com.mango.data.mapper.toDomainEntityDetail
import com.mango.domain.PengpongRepository
import com.mango.domain.entity.DomainEntityDetail
import com.mango.domain.entity.DomainEntityPengpong


//Example

class PengpongRepositoryImpl constructor(
    private val pengpongService: PengpongService,
    private val pengpongMapper: PengpongMapper
) : PengpongRepository {

    override suspend fun getList(): List<DomainEntityPengpong> {
        return pengpongMapper.mapFromEntity(
            pengpongService.getList()
        )
    }

    override suspend fun detail(id: Int): DomainEntityDetail {
        return pengpongService.detail(id).toDomainEntityDetail()
    }
}
