package com.sjcreatives.financialliteracy101.ui.budgeting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.BudgetItem
import com.sjcreatives.financialliteracy101.databinding.FragmentBudgetingBinding

class BudgetingFragment : Fragment() {

    private lateinit var binding: FragmentBudgetingBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: BudgetItemAdapter
    private val viewModel: BudgetingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBudgetingBinding.inflate(layoutInflater, container, false)

        viewPager2 = binding.viewPager
        adapter = BudgetItemAdapter()
        viewPager2.adapter = adapter

        binding.indicator.attachTo(viewPager2)

        viewModel.setBudgetItems(getListOfBudgetItems())
        viewModel.listOfBudgetItems.observe(viewLifecycleOwner){list->
            list?.let {
                adapter.submitList(list)
            }
        }
        return binding.root
    }

    private fun getListOfBudgetItems(): List<BudgetItem>{
        return listOf(
            BudgetItem(0,"Title 1",getString(R.string.info_place_holder),R.drawable.budget),
            BudgetItem(1,"Title 2",getString(R.string.info_place_holder),R.drawable.budget),
            BudgetItem(2,"Title 3",getString(R.string.info_place_holder),R.drawable.budget),
            BudgetItem(3,"Title 4",getString(R.string.info_place_holder),R.drawable.budget),
            BudgetItem(4,"Title 5",getString(R.string.info_place_holder),R.drawable.budget),
            BudgetItem(5,"Title 6",getString(R.string.info_place_holder),R.drawable.budget)

        )
    }
}