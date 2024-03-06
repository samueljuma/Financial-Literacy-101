package com.sjcreatives.financialliteracy101.ui.investing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sjcreatives.financialliteracy101.databinding.FragmentInvestItemDetailsBinding

class InvestItemDetailsFragment : Fragment() {

    private lateinit var binding: FragmentInvestItemDetailsBinding
    private val arguments: InvestItemDetailsFragmentArgs by navArgs()
    private val viewModel: InvestItemDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInvestItemDetailsBinding.inflate(layoutInflater, container, false)

        viewModel.setInvestItem(arguments.investItem)
        return binding.root
    }

}