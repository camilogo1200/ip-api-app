package com.camilogo1200.data.datasources.di

import com.camilogo1200.data.datasources.repositories.IpInfoLocalRepository
import com.camilogo1200.data.datasources.repositories.IpInfoLocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalRepositoriesInjector {

    @Binds
    abstract fun bindsLocalRepository(
        localRepository: IpInfoLocalRepositoryImpl
    ): IpInfoLocalRepository

}