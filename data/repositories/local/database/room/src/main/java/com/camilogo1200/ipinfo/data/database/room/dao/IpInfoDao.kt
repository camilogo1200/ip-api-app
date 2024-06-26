package com.camilogo1200.ipinfo.data.database.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface IpInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addIp(story: List<IpInfoEntity>): List<Long>

    @Query("SELECT * FROM ip_info ORDER BY id ASC")
    fun getIpHistory(): Flow<List<IpInfoEntity>>

    @Query("DELETE FROM ip_info")
    fun deleteAllIps()

    @Insert
    fun insertAllIps(ips: List<IpInfoEntity>)
}