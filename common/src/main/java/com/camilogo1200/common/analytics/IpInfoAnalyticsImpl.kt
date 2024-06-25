package com.camilogo1200.common.analytics

import javax.inject.Inject

class IpInfoAnalyticsImpl @Inject constructor() : IpInfoAnalytics {
    override suspend fun registerEvent(
        eventId: String,
        campaign: String,
        parameters: Map<String, String>?
    ) {
        //TODO("Not yet implemented")
    }

    override suspend fun registerAction(id: String, parameters: Map<String, String>?) {
        //TODO("Not yet implemented")
    }

}