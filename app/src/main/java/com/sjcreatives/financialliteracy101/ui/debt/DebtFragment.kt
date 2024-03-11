package com.sjcreatives.financialliteracy101.ui.debt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.DebtItem
import com.sjcreatives.financialliteracy101.databinding.FragmentDebtBinding

class DebtFragment : Fragment() {

    private lateinit var binding:FragmentDebtBinding
    private lateinit var adapter: DebtItemAdapter
    private val viewModel: DebtViewModel by viewModels()
    private lateinit var viewPager2: ViewPager2
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDebtBinding.inflate(layoutInflater, container, false)

        viewPager2 = binding.viewPager
        adapter = DebtItemAdapter()

        viewPager2.adapter = adapter
        binding.indicator.attachTo(viewPager2)

        viewModel.setListOfDebtItems(getListOfDebtItems())
        viewModel.listOfDebtItems.observe(viewLifecycleOwner){ list->
            list?.let {
                adapter.submitList(list)
            }
        }
        return binding.root
    }

    private fun getListOfDebtItems(): List<DebtItem>{
        return listOf(
            DebtItem(0, "Title1", getString(R.string.info_place_holder),R.drawable.debt),
            DebtItem(1, "Title1", getString(R.string.info_place_holder),R.drawable.debt),
            DebtItem(2, "Title1", getString(R.string.info_place_holder),R.drawable.debt),
            DebtItem(3, "Title1", getString(R.string.info_place_holder),R.drawable.debt),
            DebtItem(4, "Title1", getString(R.string.info_place_holder),R.drawable.debt),
            DebtItem(5, "Title1", getString(R.string.info_place_holder),R.drawable.debt)

        )
    }

}