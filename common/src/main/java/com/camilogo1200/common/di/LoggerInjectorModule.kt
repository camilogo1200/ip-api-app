package com.camilogo1200.common.di

import com.camilogo1200.common.logger.IpInfoLogger
import com.camilogo1200.common.logger.IpInfoLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoggerInjectorModule {

    @Binds
    abstract fun bindsLogger(
        loggerAbstraction: IpInfoLoggerImpl
    ): IpInfoLogger
}