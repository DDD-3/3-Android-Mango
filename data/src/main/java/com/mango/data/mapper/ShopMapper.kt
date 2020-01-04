package com.mango.data.mapper

import com.mango.data.entitiy.DataEntityDetail
import com.mango.data.entitiy.DataEntityNews
import com.mango.data.entitiy.DataEntityShop
import com.mango.data.entitiy.DataEntityTag
import com.mango.domain.entity.DomainEntityDetail
import com.mango.domain.entity.DomainEntityNews
import com.mango.domain.entity.DomainEntityShop
import com.mango.domain.entity.DomainEntityTag

class ShopMapper : Mapper<List<DataEntityShop>, List<DomainEntityShop>> {
    override fun mapFromEntity(type: List<DataEntityShop>): List<DomainEntityShop> {
        return type.map {
            with(it) {
                DomainEntityShop(
                    address, description, id, profileImage, tel, title
                )
            }
        }

    }

}

fun DataEntityTag.mapDomainEntityTag() = DomainEntityTag(id = id, title = title)

fun List<DataEntityTag>.mapDomainEntityTagList() = this.map { it.mapDomainEntityTag() }

fun DataEntityNews.mapDomainEntityNews() =
    DomainEntityNews(id = id, imageUrl = imageUrl, link = link)

fun List<DataEntityNews>.mapDomainEntityNewsList() = this.map { it.mapDomainEntityNews() }

fun DataEntityDetail.toDomainEntityDetail() = DomainEntityDetail(
    id = id,
    backgroundUrl = backgroundUrl,
    tel = tel,
    title = title,
    address = address,
    description = description,
    tags = tags?.mapDomainEntityTagList(),
    news = news?.mapDomainEntityNewsList()
)