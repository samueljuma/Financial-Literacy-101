package com.sjcreatives.financialliteracy101.ui.tax

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.TaxItem
import com.sjcreatives.financialliteracy101.databinding.FragmentTaxBinding

class TaxFragment : Fragment() {

    private lateinit var binding: FragmentTaxBinding
    private lateinit var adapter: TaxItemAdapter
    private val viewModel: TaxViewModel by viewModels()

    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTaxBinding.inflate(layoutInflater,container,false)

        viewPager2 = binding.viewPager

        adapter = TaxItemAdapter()
        viewPager2.adapter = adapter

        binding.indicator.attachTo(viewPager2)

        viewModel.setListOfTaxItems(getListOfTaxItems())
        viewModel.listOfTaxItems.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }
        return binding.root

    }

    private fun getListOfTaxItems(): List<TaxItem>{
        return listOf(
            TaxItem(0, "Title 1", getString(R.string.info_place_holder), R.drawable.tax),
            TaxItem(1, "Title 1", getString(R.string.info_place_holder), R.drawable.tax),
            TaxItem(2, "Title 1", getString(R.string.info_place_holder), R.drawable.tax),
            TaxItem(3, "Title 1", getString(R.string.info_place_holder), R.drawable.tax),
            TaxItem(4, "Title 1", getString(R.string.info_place_holder), R.drawable.tax),
            TaxItem(5, "Title 1", getString(R.string.info_place_holder), R.drawable.tax)
        )
    }

}