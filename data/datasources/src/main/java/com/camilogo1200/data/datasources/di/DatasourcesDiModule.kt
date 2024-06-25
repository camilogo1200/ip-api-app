package com.camilogo1200.data.datasources.di

import com.camilogo1200.data.datasources.local.IpInfoLocalDataSources
import com.camilogo1200.data.datasources.local.IpInfoLocalDataSourcesImpl
import com.camilogo1200.data.datasources.remote.IpInfoRemoteDatasource
import com.camilogo1200.data.datasources.remote.IpInfoRemoteDatasourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesDiModule {

    @Binds
    abstract fun bindsRemoteDatasource(
        remoteDatasource: IpInfoRemoteDatasourceImpl
    ): IpInfoRemoteDatasource

    @Binds
    abstract fun bindsLocalDatasource(
        localDataSource: IpInfoLocalDataSourcesImpl
    ): IpInfoLocalDataSources
}
