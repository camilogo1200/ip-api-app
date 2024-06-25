package com.camilogo1200.permissions.ui.fragments

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.camilogo1200.permissions.R
import com.camilogo1200.permissions.databinding.FragmentRequestPermissionsWizardBinding
import com.camilogo1200.permissions.ui.adapters.RequestPermissionsViewPagerAdapter

const val numPages = 2

class RequestPermissionsWizardFragment : Fragment() {

    private lateinit var binding: FragmentRequestPermissionsWizardBinding
    private lateinit var viewPager: ViewPager2


    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(
            this, callback
        )
    }

    private val callback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            if (viewPager.currentItem == 0) {
                requireActivity().onBackPressedDispatcher.onBackPressed()
            } else {
                viewPager.currentItem -= 1
            }
        }
    }

    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
            } else {
                // Explain to the user that the feature is unavailable because the
                // feature requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
            }
        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<FragmentRequestPermissionsWizardBinding>(
            inflater, R.layout.fragment_request_permissions_wizard, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        requestPermissions()
    }

    private fun bindViewPager() {
        viewPager = binding.permissionsViewPager
        val fragments = listOf(
            RequestLocationPermissionFragment.newInstance()
        )
        val pagerAdapter =
            RequestPermissionsViewPagerAdapter(
                fragments,
                parentFragmentManager,
                viewLifecycleOwner.lifecycle
            )
        viewPager.adapter = pagerAdapter
    }

    private fun requestPermissions() {
        when {
            ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED -> {
                val navController = findNavController()
                // navController.navigate()
            }

            ActivityCompat.shouldShowRequestPermissionRationale(
                requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION
            ) -> {

            }

            else -> {
                bindViewPager()
                //requestPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }
    }


}