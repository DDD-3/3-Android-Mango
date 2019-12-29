package com.mango.domain.entity

data class DomainEntityDetail(
    val id: Int,
    val backgroundUrl: String?,
    val tel: String?,
    val title: String?,
    val address: String?,
    val description: String?,
    val tags: List<DomainEntityTag>?,
    val news: List<DomainEntityNews>?
)