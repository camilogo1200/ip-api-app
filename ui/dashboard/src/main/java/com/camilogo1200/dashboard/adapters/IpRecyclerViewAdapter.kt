package com.camilogo1200.dashboard.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.camilogo1200.dashboard.R
import com.camilogo1200.dashboard.databinding.IpInfoItemBinding
import com.camilogo1200.ipinfo.domain.ipmodels.IpInfo

class IpRecyclerViewAdapter(private val ipInfoList: List<IpInfo>) :
    RecyclerView.Adapter<IpViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IpViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: IpInfoItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.ip_info_item, parent, false)
        return IpViewHolder(binding)
    }

    override fun getItemCount(): Int = ipInfoList.size

    override fun onBindViewHolder(holder: IpViewHolder, position: Int) {
        holder.bind(ipInfoList[position])
    }
}