package com.camilogo1200.dashboard.fragments

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
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
import com.camilogo1200.dashboard.databinding.FragmentInfoBinding
import com.camilogo1200.dashboard.view_models.IpInfoViewModel
import com.camilogo1200.dashboard.view_states.IpInfoViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class InfoFragment : Fragment() {

    private val viewModel: IpInfoViewModel by viewModels()
    private lateinit var binding: FragmentInfoBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_info,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindListeners()
    }

    private fun bindListeners() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.viewState.collect { viewState ->
                    handleViewState(viewState)
                }
            }
        }
    }

    private fun handleViewState(viewState: IpInfoViewState) {
        when (viewState) {
            is IpInfoViewState.Init -> {
                viewModel.initView()
            }

            is IpInfoViewState.OnViewLoaded -> {
                handleOnViewLoaded(viewState)
            }

            is IpInfoViewState.OnFetchInfoFailed -> {
                Toast.makeText(
                    requireContext(),
                    "There was an error fetching data",
                    Toast.LENGTH_LONG
                ).show()
            }

            is IpInfoViewState.OnDataValidationFailed -> {
                //TODO show dialog with errors
                Toast.makeText(
                    requireContext(),
                    "Check the Ip address again. data validation failed.",
                    Toast.LENGTH_LONG
                ).show()
            }

            else -> {}
        }
    }

    private fun handleOnViewLoaded(onViewLoaded: IpInfoViewState.OnViewLoaded) {
        val info = onViewLoaded.info
        with(binding) {
            val editable: Editable = SpannableStringBuilder(info.query)
            homeTabIpQuery.text = editable
            homeTabIpIspText.text = info.isp
            homeTabIpCityText.text = info.city
            homeTabIpContinentText.text = info.continent
            homeTabIpCountryText.text = info.country
            homeTabIpLatitudeText.text = info.lat.toString()
            homeTabIpLongitudeText.text = info.lon.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = InfoFragment()
    }
}