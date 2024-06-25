package com.camilogo1200.ipinfo.domain.ipmodels

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IpInfo(
    @SerialName("status") var status: String? = null,
    @SerialName("continent") var continent: String? = null,
    @SerialName("country") var country: String? = null,
    @SerialName("countryCode") var countryCode: String? = null,
    @SerialName("region") var region: String? = null,
    @SerialName("regionName") var regionName: String? = null,
    @SerialName("city") var city: String? = null,
    @SerialName("district") var district: String? = null,
    @SerialName("zip") var zip: String? = null,
    @SerialName("lat") var lat: Double? = null,
    @SerialName("lon") var lon: Double? = null,
    @SerialName("timezone") var timezone: String? = null,
    @SerialName("isp") var isp: String? = null,
    @SerialName("org") var org: String? = null,
    @SerialName("as") var asNumber: String? = null,
    @SerialName("mobile") var mobile: Boolean? = null,
    @SerialName("query") var query: String? = null
)
