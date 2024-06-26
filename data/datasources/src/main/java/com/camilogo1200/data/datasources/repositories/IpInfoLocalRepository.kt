package com.camilogo1200.data.datasources.repositories

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.flow.Flow

interface IpInfoLocalRepository {
    suspend fun retrieveLocalIpInfo(): Flow<List<IpInfo>>
    suspend fun saveIpInfo(ipInformation: List<IpInfo>)
}