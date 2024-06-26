package com.camilogo1200.dashboard.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.camilogo1200.dashboard.R
import com.camilogo1200.dashboard.databinding.FragmentDashboardBinding
import com.google.android.material.navigation.NavigationBarView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val bottomNavListener =
        NavigationBarView.OnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.search_menu -> {
                    navigateToHome()
                }


                R.id.history_menu -> {
                    navigateToHistoryScreen()
                }

                R.id.profile_menu -> {
                    navigateToProfileScreen()
                }
            }
            true
        }

    private fun navigateToProfileScreen() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_go_to_profile)
    }

    private fun navigateToHistoryScreen() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(R.id.action_go_to_history)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindListeners()
    }


    private fun navigateToHome() {
        val navHost =
            childFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        val navController = navHost.navController
        navController.navigate(R.id.action_go_to_home)

    }


    private fun bindListeners() {
        binding.bottomNavigation.setOnItemSelectedListener(bottomNavListener)
    }


}