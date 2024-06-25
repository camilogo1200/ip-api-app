package com.camilogo1200.data.repositories.mappers

import com.camilogo1200.common.network.dto.IpInfoDto
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo
import javax.inject.Inject

class IpInfoDtoMapper @Inject constructor() : Mapper<IpInfoDto, IpInfo> {
    override fun to(dto: IpInfoDto): IpInfo {
        return IpInfo(
            dto.status,
            dto.continent,
            dto.country,
            dto.countryCode,
            dto.region,
            dto.regionName,
            dto.city,
            dto.district,
            dto.zip,
            dto.lat,
            dto.lon,
            dto.timezone,
            dto.isp,
            dto.org,
            dto.asNumber,
            dto.mobile,
            dto.query
        )
    }
}