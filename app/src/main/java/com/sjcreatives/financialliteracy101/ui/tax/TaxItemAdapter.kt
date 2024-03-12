package com.sjcreatives.financialliteracy101.ui.tax

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.data.models.TaxItem
import com.sjcreatives.financialliteracy101.databinding.TaxItemCardBinding

class TaxItemAdapter: ListAdapter<TaxItem, TaxItemAdapter.ViewHolder>(TaxItemDiffCallback()){
    class ViewHolder (val binding:TaxItemCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(taxItem: TaxItem) {
            binding.taxItem = taxItem
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaxItemCardBinding.inflate(layoutInflater, parent,false)
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

class TaxItemDiffCallback: DiffUtil.ItemCallback<TaxItem>(){
    override fun areItemsTheSame(oldItem: TaxItem, newItem: TaxItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaxItem, newItem: TaxItem): Boolean {
        return oldItem == newItem
    }

}
