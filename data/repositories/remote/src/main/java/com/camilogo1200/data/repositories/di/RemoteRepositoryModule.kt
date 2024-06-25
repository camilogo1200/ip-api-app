package com.camilogo1200.data.repositories.di

import com.camilogo1200.data.repositories.IpInfoRemoteRepository
import com.camilogo1200.data.repositories.IpInfoRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteRepositoryModule {

    @Binds
    abstract fun provideIpInfoRemoteRepository(
        remoteRepository: IpInfoRemoteRepositoryImpl
    ): IpInfoRemoteRepository

}