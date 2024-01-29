package com.sjcreatives.financialliteracy101.ui.saving

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sjcreatives.financialliteracy101.databinding.FragmentSavingBinding


class SavingFragment : Fragment() {

    private lateinit var binding: FragmentSavingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSavingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}