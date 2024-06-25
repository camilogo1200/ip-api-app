package com.camilogo1200.data.repositories

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

interface IpInfoRemoteRepository {
    suspend fun retrieveIpInfo(): Result<IpInfo>
}