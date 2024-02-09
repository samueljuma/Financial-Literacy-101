package com.sjcreatives.financialliteracy101.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.databinding.FragmentLatestReadBinding

class LatestReadFragment : Fragment() {

    private lateinit var binding: FragmentLatestReadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLatestReadBinding.inflate(layoutInflater, container, false)
        binding.webView.loadUrl("https://gichukikahome.com/how-lifestyle-creep-delays-your-financial-goals/")
        return binding.root
    }

}