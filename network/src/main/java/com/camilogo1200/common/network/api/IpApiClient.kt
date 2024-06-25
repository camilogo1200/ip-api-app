package com.camilogo1200.common.network.api

import com.camilogo1200.common.network.dto.IpInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IpApiClient {
    @GET("/json")
    suspend fun fetchIpInfo(
        @Query("fields") fields: String = "1699839"
    ): Response<IpInfoDto>
}