package com.camilogo1200.data.datasources.local

import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.common.logger.IpInfoLogger
import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.ipinfo.data.database.room.dao.IpInfoDao
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class IpInfoLocalDataSourcesImpl @Inject constructor(
    private val ipInfoDao: IpInfoDao,
    private val mapperEntities: Mapper<IpInfoEntity, IpInfo>,
    private val mapperModel: Mapper<IpInfo, IpInfoEntity>,
    private var logger: IpInfoLogger,
    @IoDispatcher
    private val dispatcher: CoroutineDispatcher
) : IpInfoLocalDataSources {
    override suspend fun retrieveLocalIpInfo(): Flow<List<IpInfo>> = flow {
        ipInfoDao.getIpHistory()
            .flowOn(dispatcher)
            .collect { entities ->
                val lModels = mutableListOf<IpInfo>()
                entities.onEach { entity ->
                    val model = mapperEntities.toObj(entity)
                    lModels.add(model)
                }
                emit(lModels)
            }
    }


    override suspend fun saveIpInfo(ipInformation: List<IpInfo>) {
        return withContext(dispatcher) {
            try {
                val entities = mutableListOf<IpInfoEntity>()
                ipInformation.onEach {
                    val entity = mapperModel.toObj(it)
                    entities.add(entity)
                }
                ipInfoDao.insertAllIps(entities)
            } catch (ex: Exception) {
                logger.log("An error occurred while saving IpInfo on local database")
                ex.printStackTrace()
            }
        }
    }
}