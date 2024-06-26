package com.camilogo1200.data.repositories

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

interface IpInfoRemoteRepository {
    suspend fun retrieveIpInfo(ip: String? = null): Result<IpInfo>
}