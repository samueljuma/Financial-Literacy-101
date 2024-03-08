package com.sjcreatives.financialliteracy101.ui.budgeting

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.data.models.BudgetItem
import com.sjcreatives.financialliteracy101.databinding.BudgetingItemCardBinding

class BudgetItemAdapter: ListAdapter<BudgetItem,BudgetItemAdapter.ViewHolder> (
    BudgetItemDiffCallback()) {
    class ViewHolder (val binding: BudgetingItemCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(budgetItem: BudgetItem){
            binding.budgetItem = budgetItem
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent:ViewGroup):ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = BudgetingItemCardBinding.inflate(layoutInflater, parent, false)
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

class BudgetItemDiffCallback : DiffUtil.ItemCallback<BudgetItem>() {
    override fun areItemsTheSame(oldItem: BudgetItem, newItem: BudgetItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: BudgetItem, newItem: BudgetItem): Boolean {
        return oldItem == newItem
    }

}
