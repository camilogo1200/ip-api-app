package com.camilogo1200.ipinfo.data.database.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity.Companion.IP_INFO_TABLE_NAME
import java.util.Date

@Entity(tableName = IP_INFO_TABLE_NAME)
data class IpInfoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo("status") var status: String? = null,
    @ColumnInfo("continent") var continent: String? = null,
    @ColumnInfo("country") var country: String? = null,
    @ColumnInfo("countryCode") var countryCode: String? = null,
    @ColumnInfo("region") var region: String? = null,
    @ColumnInfo("regionName") var regionName: String? = null,
    @ColumnInfo("city") var city: String? = null,
    @ColumnInfo("district") var district: String? = null,
    @ColumnInfo("zip") var zip: String? = null,
    @ColumnInfo("lat") var lat: Double? = null,
    @ColumnInfo("lon") var lon: Double? = null,
    @ColumnInfo("timezone") var timezone: String? = null,
    @ColumnInfo("isp") var isp: String? = null,
    @ColumnInfo("org") var org: String? = null,
    @ColumnInfo("as") var asNumber: String? = null,
    @ColumnInfo("mobile") var mobile: Boolean? = null,
    @ColumnInfo("query") var query: String? = null,
    @ColumnInfo("time_stamp") var timeStamp: Date? = null,
) {
    companion object {
        const val IP_INFO_TABLE_NAME = "ip_info"
    }
}
