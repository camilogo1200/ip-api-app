package com.camilogo1200.data.datasources.local

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

interface IpInfoLocalDataSources {
    suspend fun saveIpInfo(ipInformation: IpInfo): Result<IpInfo>
}