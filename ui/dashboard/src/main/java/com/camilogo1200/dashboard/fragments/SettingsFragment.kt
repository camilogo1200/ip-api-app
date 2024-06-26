package com.camilogo1200.dashboard.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.camilogo1200.dashboard.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}