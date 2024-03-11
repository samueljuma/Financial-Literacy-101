package com.sjcreatives.financialliteracy101.ui.insurance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.InsuranceItem
import com.sjcreatives.financialliteracy101.databinding.FragmentInsuranceBinding

class InsuranceFragment : Fragment() {

    private lateinit var binding: FragmentInsuranceBinding
    private lateinit var viewPager2: ViewPager2
    private lateinit var adapter: InsuranceItemAdapter
    private val viewModel: InsuranceViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInsuranceBinding.inflate(layoutInflater, container, false)

        viewPager2 = binding.viewPager

        adapter = InsuranceItemAdapter()
        viewPager2.adapter = adapter

        binding.indicator.attachTo(viewPager2)

        viewModel.setListOfInsuranceItems(getListOfInsuranceItems())
        viewModel.listOfInsuranceItems.observe(viewLifecycleOwner){list->
            list?.let {
                adapter.submitList(list)
            }
        }

        return binding.root
    }

    private fun getListOfInsuranceItems(): List<InsuranceItem>{
        return listOf(
            InsuranceItem(0,"title 1", getString(R.string.info_place_holder), R.drawable.insurance),
            InsuranceItem(0,"title 2", getString(R.string.info_place_holder), R.drawable.insurance),
            InsuranceItem(0,"title 3", getString(R.string.info_place_holder), R.drawable.insurance),
            InsuranceItem(0,"title 4", getString(R.string.info_place_holder), R.drawable.insurance),
            InsuranceItem(0,"title 5", getString(R.string.info_place_holder), R.drawable.insurance)

        )
    }

}