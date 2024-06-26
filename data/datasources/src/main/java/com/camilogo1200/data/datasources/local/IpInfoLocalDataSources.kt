package com.camilogo1200.data.datasources.local

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.flow.Flow

interface IpInfoLocalDataSources {
    suspend fun retrieveLocalIpInfo(): Flow<List<IpInfo>>
    suspend fun saveIpInfo(ipInformation: List<IpInfo>)
}