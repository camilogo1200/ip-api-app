package com.camilogo1200.dashboard.view_states

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

sealed interface HistoryViewState {
    data object Init : HistoryViewState
    data object OnViewLoadedFailed : HistoryViewState
    data class OnViewLoaded(val ipInfoList: List<IpInfo>) : HistoryViewState
}