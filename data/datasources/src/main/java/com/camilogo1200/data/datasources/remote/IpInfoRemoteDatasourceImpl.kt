package com.camilogo1200.data.datasources.remote

import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.common.logger.IpInfoLogger
import com.camilogo1200.common.network.api.IpApiClient
import com.camilogo1200.common.network.dto.IpInfoDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IpInfoRemoteDatasourceImpl @Inject constructor(
    private val ipApiInfo: IpApiClient,
    private val logger: IpInfoLogger,
    @IoDispatcher
    private val dispatcher: CoroutineDispatcher
) : IpInfoRemoteDatasource {
    override suspend fun fetchIpInfoData(): Result<IpInfoDto> {
        val errorText = "There was an error fetching IpInfo from the APi Endpoint"
        return withContext(dispatcher) {
            try {
                val response = ipApiInfo.fetchIpInfo()
                if (response.isSuccessful) {
                    val result = response.body()?.let {
                        Result.success(it)
                    } ?: Result.failure(Error(errorText))
                    result
                } else {
                    Result.failure(Error(response.errorBody().toString()))
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                Result.failure(Error(errorText))
            }
        }
    }
}