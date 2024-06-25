package com.camilogo1200.ipinfo.data.database.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity.Companion.IP_INFO_TABLE_NAME

@Entity(tableName = IP_INFO_TABLE_NAME)
data class IpInfoEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int = 0,
) {
    companion object {
        const val IP_INFO_TABLE_NAME = "ip_info"
    }
}
