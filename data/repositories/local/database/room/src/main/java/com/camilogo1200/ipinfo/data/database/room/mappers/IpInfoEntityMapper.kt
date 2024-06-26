package com.camilogo1200.ipinfo.data.database.room.mappers

import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import javax.inject.Inject

class IpInfoEntityMapper @Inject constructor() : Mapper<IpInfoEntity, IpInfo> {

    override fun toObj(obj: IpInfoEntity): IpInfo {
        return IpInfo(
            obj.status,
            obj.continent,
            obj.country,
            obj.countryCode,
            obj.region,
            obj.regionName,
            obj.city,
            obj.district,
            obj.zip,
            obj.lat,
            obj.lon,
            obj.timezone,
            obj.isp,
            obj.org,
            obj.asNumber,
            obj.mobile,
            obj.query,
            obj.timeStamp
        )
    }
}