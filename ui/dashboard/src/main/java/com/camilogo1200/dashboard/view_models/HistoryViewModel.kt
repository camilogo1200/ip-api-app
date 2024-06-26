package com.camilogo1200.dashboard.view_models

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.camilogo1200.common.coroutines.IoDispatcher
import com.camilogo1200.dashboard.view_states.HistoryViewState
import com.camilogo1200.usecases.RetrieveIpInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val useCase: RetrieveIpInformationUseCase,
    @IoDispatcher
    private val coroutineDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _viewState = MutableStateFlow<HistoryViewState>(HistoryViewState.Init)
    val viewState = _viewState.asStateFlow()

    val isLoading = ObservableBoolean(false)

    private fun setViewState(newState: HistoryViewState) {
        _viewState.value = newState
        isLoading.set(false)
    }

    fun initView() {
        viewModelScope.launch(coroutineDispatcher) {
            isLoading.set(true)
            useCase.invoke()
                .catch {
                    HistoryViewState.OnViewLoadedFailed
                }
                .flowOn(coroutineDispatcher)
                .collect { list ->
                    setViewState(HistoryViewState.OnViewLoaded(list))
                }
        }
    }


}