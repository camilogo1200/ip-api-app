package com.camilogo1200.common.di

import com.camilogo1200.common.analytics.IpInfoAnalytics
import com.camilogo1200.common.analytics.IpInfoAnalyticsImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface AnalyticsInjectorModule {

    @Binds
    abstract fun bindsAnalyticInjector(
        analyticInjector: IpInfoAnalyticsImpl
    ): IpInfoAnalytics

}