package com.camilogo1200.common.network.di

import com.camilogo1200.common.network.api.IpApiClient
import com.camilogo1200.ipinfo.ui.home.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Provides
    fun providesIpApiService(
        retrofitBuilder: Retrofit.Builder,
    ): IpApiClient {
        val retrofit = retrofitBuilder
            .baseUrl("http://ip-api.com/json/").build()
        return retrofit.create(IpApiClient::class.java)
    }
}