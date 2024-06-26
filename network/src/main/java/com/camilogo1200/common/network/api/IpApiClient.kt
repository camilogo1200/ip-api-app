package com.camilogo1200.common.network.api

import com.camilogo1200.common.network.dto.IpInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IpApiClient {
    @GET("/json/{ip}")
    suspend fun fetchIpInfo(
        @Path("ip") ip: String = "",
        @Query("fields") fields: String = "1699839"
    ): Response<IpInfoDto>
}