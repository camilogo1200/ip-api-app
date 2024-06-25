package com.camilogo1200.permissions.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.camilogo1200.permissions.ui.fragments.RequestPermissionsWizardFragment
import com.camilogo1200.permissions.ui.fragments.numPages

class RequestPermissionsViewPagerAdapter(
    private val fragmentList: List<Fragment>,
    private val fragmentManager: FragmentManager,
    private val lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = numPages

    override fun createFragment(position: Int): Fragment {
        val fragment = fragmentList[position]
        return fragment
    }

}
