package com.camilogo1200.dashboard.adapters

import androidx.recyclerview.widget.RecyclerView
import com.camilogo1200.dashboard.databinding.IpInfoItemBinding
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

data class IpViewHolder(private val binding: IpInfoItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(ipInfo: IpInfo) {
        binding.ipQuery.text = ipInfo.query
        binding.timestamp.text = ipInfo.timeStamp.toString()
        binding.continent.text = ipInfo.continent
        binding.country.text = ipInfo.country
        binding.city.text = ipInfo.city
    }

}