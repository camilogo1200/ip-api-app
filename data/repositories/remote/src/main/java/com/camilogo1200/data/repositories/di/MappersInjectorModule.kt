package com.camilogo1200.data.repositories.di

import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.common.network.dto.IpInfoDto
import com.camilogo1200.data.repositories.mappers.IpInfoDtoMapper
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MappersInjectorModule {

    @Binds
    abstract fun providesIpInfoMapper(
        mapper: IpInfoDtoMapper
    ): Mapper<IpInfoDto, IpInfo>
}