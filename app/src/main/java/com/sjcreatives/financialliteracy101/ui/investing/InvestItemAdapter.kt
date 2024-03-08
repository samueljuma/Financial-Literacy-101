package com.sjcreatives.financialliteracy101.ui.investing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.data.models.InvestItem
import com.sjcreatives.financialliteracy101.databinding.InvestingItemCardBinding

class InvestItemAdapter (
    val clickListener: InvestItemClickListener
): ListAdapter<InvestItem, InvestItemAdapter.ViewHolder> (InvestItemDiffCallback())  {

    class ViewHolder(val binding: InvestingItemCardBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (investItem: InvestItem, clickListener: InvestItemClickListener){
            binding.clickListener = clickListener
            binding.investItem = investItem
            binding.executePendingBindings()
        }

        companion object{
            fun from (parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = InvestingItemCardBinding.inflate(layoutInflater, parent, false)
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

class InvestItemClickListener (val clickListener: (investItem: InvestItem) -> Unit) {
    fun onClick(investItem: InvestItem) = clickListener(investItem)
}

class InvestItemDiffCallback : DiffUtil.ItemCallback<InvestItem>() {
    override fun areItemsTheSame(oldItem: InvestItem, newItem: InvestItem): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: InvestItem, newItem: InvestItem): Boolean {
        return oldItem == newItem
    }

}
