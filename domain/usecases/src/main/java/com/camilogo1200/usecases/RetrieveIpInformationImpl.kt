package com.camilogo1200.usecases

import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.common.logger.IpInfoLogger
import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.common.network.dto.IpInfoDto
import com.camilogo1200.data.datasources.local.IpInfoLocalDataSources
import com.camilogo1200.data.datasources.remote.IpInfoRemoteDatasource
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RetrieveIpInformationImpl @Inject constructor(
    private val remoteDatasource: IpInfoRemoteDatasource,
    private val localDataSources: IpInfoLocalDataSources,
    private val ipInfoMapper: Mapper<IpInfoDto, IpInfo>,
    private val logger: IpInfoLogger,
    @IoDispatcher
    private val coroutineDispatcher: CoroutineDispatcher
) : RetrieveIpInformationUseCase {

    private val errorText = "An error has occurred on RetrieveIpInformationUseCase."

    override suspend fun invoke(): Flow<List<IpInfo>> = flow {
        localDataSources.retrieveLocalIpInfo()
            .catch { ex ->
                logger.log(errorText, ex)
            }.flowOn(coroutineDispatcher)
            .collect { lIpInfo ->
                var ipInfoList = mutableListOf<IpInfo>()
                if (lIpInfo.isEmpty()) {
                    ipInfoList = retrieveRemoteIpInfo().toMutableList()
                    saveIpInfo(ipInfoList)
                    emit(ipInfoList)
                } else {
                    emit(lIpInfo)
                }
            }
    }

    private suspend fun saveIpInfo(lInfo: List<IpInfo>) =
        localDataSources.saveIpInfo(lInfo)

    private suspend fun retrieveRemoteIpInfo(): List<IpInfo> {
        val result = remoteDatasource.fetchIpInfoData(null)
        return if (result.isSuccess) {
            val dto = result.getOrNull()
            dto?.let {
                val model = ipInfoMapper.toObj(dto)
                listOf(model)
            } ?: emptyList()
        } else {
            emptyList()
        }
    }
}
