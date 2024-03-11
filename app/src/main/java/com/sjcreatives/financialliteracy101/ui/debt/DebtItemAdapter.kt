package com.sjcreatives.financialliteracy101.ui.debt

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.data.models.DebtItem
import com.sjcreatives.financialliteracy101.databinding.DebtItemCardBinding

class DebtItemAdapter: ListAdapter<DebtItem, DebtItemAdapter.ViewHolder>(DebtItemDiffCallback()) {
    class ViewHolder(val binding:DebtItemCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(debtItem: DebtItem){
            binding.debtItem = debtItem
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup): ViewHolder{
                val binding = DebtItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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

class DebtItemDiffCallback: DiffUtil.ItemCallback<DebtItem>() {
    override fun areItemsTheSame(oldItem: DebtItem, newItem: DebtItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DebtItem, newItem: DebtItem): Boolean {
        return oldItem == newItem
    }

}
