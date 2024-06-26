package com.camilogo1200.ipinfo.data.database.room.di

import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity
import com.camilogo1200.ipinfo.data.database.room.mappers.IpInfoEntityMapper
import com.camilogo1200.ipinfo.data.database.room.mappers.IpInfoEntityModelMapper
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperLocalInjectorModule {
    @Binds
    abstract fun bindsIpInfoEntityMapper(
        mapper: IpInfoEntityMapper
    ): Mapper<IpInfoEntity, IpInfo>

    @Binds
    abstract fun bindsIpInfoEntityModelMapper(
        mapper: IpInfoEntityModelMapper
    ): Mapper<IpInfo, IpInfoEntity>

}