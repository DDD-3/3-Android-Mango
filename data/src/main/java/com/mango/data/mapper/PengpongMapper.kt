package com.mango.data.mapper

import com.mango.data.entitiy.DataEntityPengpong
import com.mango.domain.entity.DomainEntityPengpong

class PengpongMapper : Mapper<List<DataEntityPengpong>, List<DomainEntityPengpong>> {
    override fun mapFromEntity(type: List<DataEntityPengpong>): List<DomainEntityPengpong> {
        return type.map {
            with(it) {
                DomainEntityPengpong(
                    address, description, id, profileImage, tel, title
                )
            }
        }

    }

}