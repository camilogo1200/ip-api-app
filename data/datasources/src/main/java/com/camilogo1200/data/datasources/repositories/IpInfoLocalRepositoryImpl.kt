package com.camilogo1200.data.datasources.repositories

import com.camilogo1200.data.datasources.local.IpInfoLocalDataSources
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class IpInfoLocalRepositoryImpl @Inject constructor(
    private val localDataSources: IpInfoLocalDataSources
) : IpInfoLocalRepository {
    override suspend fun retrieveLocalIpInfo(): Flow<List<IpInfo>> =
        localDataSources.retrieveLocalIpInfo()

    override suspend fun saveIpInfo(ipInformation: List<IpInfo>) =
        localDataSources.saveIpInfo(ipInformation)
}