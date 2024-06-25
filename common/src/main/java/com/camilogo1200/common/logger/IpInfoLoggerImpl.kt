package com.camilogo1200.common.logger

import javax.inject.Inject

class IpInfoLoggerImpl @Inject constructor() : IpInfoLogger {
    override suspend fun log(
        message: String,
        throwable: Throwable?,
        parameters: Map<String, String>?
    ) {
        //TODO("Not yet implemented")
    }
}