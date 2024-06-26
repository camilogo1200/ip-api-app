package com.camilogo1200.data.datasources.remote

import com.camilogo1200.common.network.dto.IpInfoDto

interface IpInfoRemoteDatasource {
    suspend fun fetchIpInfoData(ip: String?): Result<IpInfoDto>
}