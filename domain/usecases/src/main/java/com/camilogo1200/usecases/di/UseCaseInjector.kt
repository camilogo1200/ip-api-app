package com.camilogo1200.usecases.di

import com.camilogo1200.usecases.RetrieveIpInformationImpl
import com.camilogo1200.usecases.RetrieveIpInformationUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseInjector {
    @Binds
    abstract fun bindsRetrieveIpInfoUseCase(
        useCase: com.camilogo1200.usecases.RetrieveIpInformationImpl
    ): com.camilogo1200.usecases.RetrieveIpInformationUseCase
}