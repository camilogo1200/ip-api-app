package com.camilogo1200.dashboard.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.data.repositories.IpInfoRemoteRepository
import com.camilogo1200.dashboard.view_states.IpInfoViewState
import com.camilogo1200.dashboard.view_states.IpInfoViewState.Init
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IpInfoViewModel @Inject constructor(
    private val ipInfoRemoteRepository: IpInfoRemoteRepository,
    @IoDispatcher
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _viewState = MutableStateFlow<IpInfoViewState>(Init)
    val viewState = _viewState.asStateFlow()

    private fun setState(newState: IpInfoViewState) {
        _viewState.value = newState
    }

    fun initView() {
        viewModelScope.launch(coroutineDispatcher) {
            runCatching {
                val result = ipInfoRemoteRepository.retrieveIpInfo()
                val ipInfo = result.getOrNull()
                ipInfo
            }.onSuccess { ipInfo ->
                ipInfo?.let {
                    setState(IpInfoViewState.OnViewLoaded(ipInfo))
                } ?: setState(IpInfoViewState.OnFetchInfoFailed)
            }.onFailure {
                setState(IpInfoViewState.OnFetchInfoFailed)
            }
        }
    }

}