package com.sjcreatives.financialliteracy101.ui.investing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.InvestItem
import com.sjcreatives.financialliteracy101.databinding.FragmentInvestingBinding
import com.sjcreatives.financialliteracy101.ui.adapters.InvestItemAdapter

class InvestingFragment : Fragment() {

    private lateinit var binding: FragmentInvestingBinding

    private lateinit var adapter: InvestItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInvestingBinding.inflate(layoutInflater, container, false)

        val listOfInvestItems = listOf(
            InvestItem(0,"Stock",getString(R.string.stocks_desc),R.drawable.what),
            InvestItem(1,"Bonds",getString(R.string.stocks_desc),R.drawable.what),
            InvestItem(2,"Real Estate",getString(R.string.stocks_desc),R.drawable.what),
            InvestItem(3,"Sacco",getString(R.string.stocks_desc),R.drawable.what),
            InvestItem(4,"Unit Trusts",getString(R.string.stocks_desc),R.drawable.what),
            )

        adapter = InvestItemAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        adapter.submitList(listOfInvestItems)
        return binding.root
    }

}