package com.camilogo1200.dashboard.view_models

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.dashboard.view_states.IpInfoViewState
import com.camilogo1200.dashboard.view_states.IpInfoViewState.Init
import com.camilogo1200.data.datasources.repositories.IpInfoLocalRepository
import com.camilogo1200.data.repositories.IpInfoRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class IpInfoViewModel @Inject constructor(
    private val ipInfoRemoteRepository: IpInfoRemoteRepository,
    private val ipInfoLocalRepository: IpInfoLocalRepository,
    @IoDispatcher
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val pattern: Pattern = Pattern.compile(
        "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"
    )

    val isLoading = ObservableBoolean(false)
    var ipText: String = ""
    private val _viewState = MutableStateFlow<IpInfoViewState>(Init)
    val viewState = _viewState.asStateFlow()

    private fun setState(newState: IpInfoViewState) {
        _viewState.value = newState
        isLoading.set(false)
    }

    fun searchIp() {
        viewModelScope.launch(coroutineDispatcher) {
            isLoading.set(true)
            if (isValidIp(ipText)) {
                retrieveIpInfo(ipText)
            } else {
                setState(IpInfoViewState.OnDataValidationFailed(ipText))
            }
        }
    }

    fun isValidIp(ipText: String): Boolean {
        return pattern.matcher(ipText).matches()
    }

    fun initView() {
        viewModelScope.launch(coroutineDispatcher) {
            isLoading.set(true)
            retrieveIpInfo()
        }
    }

    private suspend fun retrieveIpInfo(ip: String? = null) {
        runCatching {
            val result = ipInfoRemoteRepository.retrieveIpInfo(ip)
            val ipInfo = result.getOrNull()?.apply {
                ipInfoLocalRepository.saveIpInfo(listOf(this))
            }
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