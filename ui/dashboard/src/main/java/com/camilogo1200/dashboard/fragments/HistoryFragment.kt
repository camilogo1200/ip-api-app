package com.camilogo1200.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.camilogo1200.dashboard.R
import com.camilogo1200.dashboard.adapters.IpRecyclerViewAdapter
import com.camilogo1200.dashboard.databinding.FragmentHistoryBinding
import com.camilogo1200.dashboard.view_models.HistoryViewModel
import com.camilogo1200.dashboard.view_states.HistoryViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_history, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindObservables()
    }

    private fun bindObservables() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.viewState.collect {
                    handleViewState(it)
                }
            }
        }

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun handleViewState(viewState: HistoryViewState) {
        when (viewState) {
            is HistoryViewState.Init -> {
                viewModel.initView()
            }

            is HistoryViewState.OnViewLoaded -> {
                handleOnViewLoaded(viewState)
            }

            is HistoryViewState.OnViewLoadedFailed -> {
                Toast.makeText(requireContext(), "Load Ip Information Failed", Toast.LENGTH_LONG)
                    .show()
            }

            else -> {}
        }
    }

    private fun handleOnViewLoaded(onViewLoaded: HistoryViewState.OnViewLoaded) {
        val adapter = IpRecyclerViewAdapter(onViewLoaded.ipInfoList)
        binding.historyRv.adapter = adapter
    }


    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment()
    }
}