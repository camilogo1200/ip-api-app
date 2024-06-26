package com.camilogo1200.usecases

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.flow.Flow

interface RetrieveIpInformationUseCase {
    suspend fun invoke(): Flow<List<IpInfo>>
}