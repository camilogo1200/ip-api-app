package com.camilogo1200.common.network

import com.camilogo1200.common.ext.ignoreAllSSLErrors
import com.camilogo1200.ipinfo.ui.home.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    private val APPLICATION_JSON_MEDIA_TYPE = "application/json"

    private val jsonProperties = Json {
        isLenient = true
        ignoreUnknownKeys = true
        prettyPrint = true
    }

    @ExperimentalSerializationApi
    @Provides
    fun providesKotlinxConverterFactory(): Converter.Factory {
        val contentType = APPLICATION_JSON_MEDIA_TYPE.toMediaType()
        return jsonProperties.asConverterFactory(contentType)
    }

    @Singleton
    @Provides
    fun providesRetrofitClient(
        okHttpclient: OkHttpClient, converterFactory: Converter.Factory
    ): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(converterFactory)
            .client(okHttpclient)
    }


    @Provides
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .ignoreAllSSLErrors()
        return builder.build()
    }

    @Provides
    fun provideInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        val logLevel = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else HttpLoggingInterceptor.Level.NONE
        interceptor.setLevel(logLevel)
        return interceptor
    }
}
