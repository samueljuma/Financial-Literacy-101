package com.sjcreatives.financialliteracy101.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.databinding.LatestReadItemBinding
import com.sjcreatives.financialliteracy101.data.models.LatestRead

class LatestReadsAdapter (
    private val clickListener: LatestReadClickListener
): ListAdapter<LatestRead, LatestReadsAdapter.ViewHolder>(
    LatestReadDiffCallback()
) {
    class ViewHolder (val binding:LatestReadItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(latestRead: LatestRead, clickListener: LatestReadClickListener){
            binding.latestRead = latestRead
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent:ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LatestReadItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener)
    }
}

class LatestReadDiffCallback : DiffUtil.ItemCallback<LatestRead>() {
    override fun areItemsTheSame(oldItem: LatestRead, newItem: LatestRead): Boolean {
        return  oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LatestRead, newItem: LatestRead): Boolean {
        return oldItem == newItem
    }

}

class LatestReadClickListener (val clickListener: (latestRead: LatestRead) -> Unit) {
    fun onClick(latestRead: LatestRead) = clickListener(latestRead)

}

