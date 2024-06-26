package com.camilogo1200.ipinfo.data.database.room.mappers

import com.camilogo1200.common.mapper.Mapper
import com.camilogo1200.ipinfo.data.database.room.entities.IpInfoEntity
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import javax.inject.Inject

class IpInfoEntityModelMapper @Inject constructor() : Mapper<IpInfo, IpInfoEntity> {
    override fun toObj(obj: IpInfo): IpInfoEntity {
        return IpInfoEntity(
            status = obj.status,
            continent = obj.continent,
            country = obj.country,
            countryCode = obj.countryCode,
            region = obj.region,
            regionName = obj.regionName,
            city = obj.city,
            district = obj.district,
            zip = obj.zip,
            lat = obj.lat,
            lon = obj.lon,
            timezone = obj.timezone,
            isp = obj.isp,
            org = obj.org,
            asNumber = obj.asNumber,
            mobile = obj.mobile,
            query = obj.query,
            timeStamp = obj.timeStamp
        )
    }
}