package com.sjcreatives.financialliteracy101.ui.saving

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.SavingItem
import com.sjcreatives.financialliteracy101.databinding.FragmentSavingBinding


class SavingFragment : Fragment() {

    private lateinit var binding: FragmentSavingBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var savingItemAdapter: SavingItemAdapter

    private val viewModel: SavingViewModel by viewModels()

    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSavingBinding.inflate(layoutInflater, container, false)

        viewPager = binding.viewPager
        savingItemAdapter = SavingItemAdapter()
        viewPager.adapter = savingItemAdapter

        binding.indicator.attachTo(viewPager)

        viewModel.setSavingItems(getListOfSavingItems())
        viewModel.listOfSavingItems.observe(viewLifecycleOwner){list ->
            list?.let {
                savingItemAdapter.submitList(list)
            }
        }

        bottomNavigationView = binding.bottomNavigation

        bottomNavigationView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.homeFragment -> {
                    this.findNavController().navigate(
                        SavingFragmentDirections.actionSavingFragmentToHomeFragment()
                    )
                    true
                }

                else -> false
            }
        }

        return binding.root
    }

    private fun getListOfSavingItems(): List<SavingItem>{
        return  listOf(
            SavingItem(1,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(2,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(3,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(4,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(5,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(6,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(7,"What is Saving?",  getString(R.string.saving_def)),
            SavingItem(8,"What is Saving?",  getString(R.string.saving_def))
        )
    }

}