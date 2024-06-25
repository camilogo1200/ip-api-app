package com.camilogo1200.common.analytics

interface IpInfoAnalytics {
    suspend fun registerEvent(eventId: String, campaign: String) =
        registerEvent(eventId, campaign, null)

    suspend fun registerEvent(eventId: String, campaign: String, parameters: Map<String, String>?)
    suspend fun registerAction(id: String) = registerAction(id, null)
    suspend fun registerAction(id: String, parameters: Map<String, String>?)
}