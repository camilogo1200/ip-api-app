package com.camilogo1200.common.logger

interface IpInfoLogger {
    suspend fun log(message: String) = log(message, null)
    suspend fun log(message: String, throwable: Throwable?) = log(message, throwable, null)
    suspend fun log(message: String, throwable: Throwable?, parameters: Map<String, String>?)
}