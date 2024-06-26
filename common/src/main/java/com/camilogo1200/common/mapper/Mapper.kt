package com.camilogo1200.common.mapper

interface Mapper<T : Any, obj : Any> {
    fun toObj(obj: T): obj
}