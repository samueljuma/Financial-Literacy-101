package com.sjcreatives.financialliteracy101.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.data.models.SavingItem
import com.sjcreatives.financialliteracy101.databinding.SavingsCardItemBinding

class SavingItemAdapter: ListAdapter<SavingItem, SavingItemAdapter.ViewHolder>(SavingItemDiffCallback()) {
    class ViewHolder(val binding: SavingsCardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(savingItem: SavingItem){
            binding.savingItem = savingItem
            binding.executePendingBindings()
        }
        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SavingsCardItemBinding.inflate(layoutInflater, parent,false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class SavingItemDiffCallback : DiffUtil.ItemCallback<SavingItem>() {
    override fun areItemsTheSame(oldItem: SavingItem, newItem: SavingItem): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SavingItem, newItem: SavingItem): Boolean {
        return oldItem == newItem
    }

}
