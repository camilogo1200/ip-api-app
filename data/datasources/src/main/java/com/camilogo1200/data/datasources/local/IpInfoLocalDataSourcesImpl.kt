package com.camilogo1200.data.datasources.local

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import javax.inject.Inject

class IpInfoLocalDataSourcesImpl @Inject constructor() : IpInfoLocalDataSources {
    override suspend fun saveIpInfo(ipInformation: IpInfo): Result<IpInfo> {
        TODO("Not yet implemented")
    }
}