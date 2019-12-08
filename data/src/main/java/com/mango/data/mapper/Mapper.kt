package com.mango.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(type: E): D
}