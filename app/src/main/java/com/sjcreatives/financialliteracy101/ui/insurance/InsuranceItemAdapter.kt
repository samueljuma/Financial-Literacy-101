package com.sjcreatives.financialliteracy101.ui.insurance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.data.models.InsuranceItem
import com.sjcreatives.financialliteracy101.databinding.InsuranceItemCardBinding

class InsuranceItemAdapter : ListAdapter<InsuranceItem, InsuranceItemAdapter.ViewHolder>(
    InsuranceItemDiffCallback()) {
    class ViewHolder(val binding: InsuranceItemCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(insuranceItem: InsuranceItem){
            binding.insuranceItem = insuranceItem
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = InsuranceItemCardBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }
}

class InsuranceItemDiffCallback: DiffUtil.ItemCallback<InsuranceItem>() {
    override fun areItemsTheSame(oldItem: InsuranceItem, newItem: InsuranceItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: InsuranceItem, newItem: InsuranceItem): Boolean {
        return oldItem == newItem
    }

}
