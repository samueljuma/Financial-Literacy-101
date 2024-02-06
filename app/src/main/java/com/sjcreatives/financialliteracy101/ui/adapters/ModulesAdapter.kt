package com.sjcreatives.financialliteracy101.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sjcreatives.financialliteracy101.databinding.ModuleItemBinding
import com.sjcreatives.financialliteracy101.data.models.LearningModule

class ModulesAdapter (
    private val clickListener: ModuleClickListener
): ListAdapter<LearningModule, ModulesAdapter.ViewHolder>(ModuleDiffCallback()) {

    class ViewHolder (val binding: ModuleItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(learningModule: LearningModule, clickListener: ModuleClickListener){
            binding.learningModule = learningModule
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ModuleItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position)!!, clickListener )
    }

}

class ModuleDiffCallback: DiffUtil.ItemCallback<LearningModule>() {
    override fun areItemsTheSame(oldItem: LearningModule, newItem: LearningModule): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: LearningModule, newItem: LearningModule): Boolean {
        return oldItem == newItem
    }

}

class ModuleClickListener(val clickListener: (module: LearningModule) -> Unit) {
    fun onClick(module: LearningModule) = clickListener(module)
}

