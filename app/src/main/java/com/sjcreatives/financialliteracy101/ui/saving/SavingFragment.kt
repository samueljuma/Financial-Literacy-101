package com.sjcreatives.financialliteracy101.ui.saving

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.SavingItem
import com.sjcreatives.financialliteracy101.databinding.FragmentSavingBinding
import com.sjcreatives.financialliteracy101.ui.adapters.SavingItemAdapter


class SavingFragment : Fragment() {

    private lateinit var binding: FragmentSavingBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var savingItemAdapter: SavingItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSavingBinding.inflate(layoutInflater, container, false)

        viewPager = binding.viewPager
        savingItemAdapter = SavingItemAdapter()
        viewPager.adapter = savingItemAdapter

        TabLayoutMediator(binding.tabLayout, viewPager){tab, position ->


        }.attach()
        val savingCards = listOf(
            SavingItem(1,"What is Saving?",  R.string.saving_def.toString()),
            SavingItem(2,"What is Saving?",  R.string.saving_def.toString()),
            SavingItem(3,"What is Saving?",  R.string.saving_def.toString())
        )
        savingItemAdapter.submitList(savingCards)

        return binding.root
    }

}