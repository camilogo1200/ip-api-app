package com.camilogo1200.data.repositories.mappers

interface Mapper<T : Any, to : Any> {
    fun to(dto: T): to
}