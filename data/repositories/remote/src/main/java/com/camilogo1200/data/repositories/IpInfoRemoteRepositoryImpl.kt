package com.camilogo1200.data.repositories

import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.common.logger.IpInfoLogger
import com.camilogo1200.common.network.dto.IpInfoDto
import com.camilogo1200.data.datasources.remote.IpInfoRemoteDatasource
import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IpInfoRemoteRepositoryImpl @Inject constructor(
    private val remoteDataSource: IpInfoRemoteDatasource,
    private val ipInfoMapper: Mapper<IpInfoDto, IpInfo>,
    private val logger: IpInfoLogger,
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher
) : IpInfoRemoteRepository {
    override suspend fun retrieveIpInfo(ip: String?): Result<IpInfo> {
        val errorText = "An error retrieving Ip Info from Api has occurred."
        return withContext(ioDispatcher) {
            val resultDto = remoteDataSource.fetchIpInfoData(ip)
            if (resultDto.isSuccess) {
                resultDto.getOrNull()?.let { dto ->
                    val ipInfo = ipInfoMapper.toObj(dto)
                    Result.success(ipInfo)
                } ?: Result.failure(Error(errorText))
            } else {
                logger.log(errorText, resultDto.exceptionOrNull())
                Result.failure(
                    resultDto.exceptionOrNull()
                        ?: Error()
                )
            }
        }
    }
}