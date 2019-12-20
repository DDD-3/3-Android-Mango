package com.mango.data.mapper

import com.mango.data.entitiy.DataEntityPengpong
import com.mango.domain.entity.DomainEntityPengpong

class PengpongMapper : Mapper<DataEntityPengpong, List<DomainEntityPengpong>> {
    override fun mapFromEntity(type: DataEntityPengpong): List<DomainEntityPengpong> {
        return type.items.map {
            with(it) {
                DomainEntityPengpong(
                    address, description, id, profileImage, tel, title
                )
            }
        }
    }

}