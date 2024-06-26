package com.camilogo1200.dashboard.view_states

import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

sealed interface IpInfoViewState {
    data object Init : IpInfoViewState
    data object Loading : IpInfoViewState
    data object OnFetchInfoFailed : IpInfoViewState
    data class OnViewLoaded(val info: IpInfo) : IpInfoViewState
    data class OnDataValidationFailed(val ipText: String) : IpInfoViewState
}