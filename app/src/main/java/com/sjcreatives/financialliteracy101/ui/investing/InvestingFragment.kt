package com.sjcreatives.financialliteracy101.ui.investing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.InvestItem
import com.sjcreatives.financialliteracy101.databinding.FragmentInvestingBinding

class InvestingFragment : Fragment() {

    private lateinit var binding: FragmentInvestingBinding
    private  val viewModel: InvestViewModel by viewModels()

    private lateinit var adapter: InvestItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInvestingBinding.inflate(layoutInflater, container, false)

        viewModel.setInvestItems(getListOfInvestItems())

        adapter = InvestItemAdapter(InvestItemClickListener { investItem ->
            viewModel.onInvestItemClicked(investItem)
        })

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context,2)

        viewModel.listOfInvestItems.observe(viewLifecycleOwner){list ->
            list?.let {
                adapter.submitList(list)
            }
        }

        viewModel.navigateToDetails.observe(viewLifecycleOwner){investItem ->
            investItem?.let {
                this.findNavController().navigate(
                    InvestingFragmentDirections.actionInvestingFragmentToInvestItemDetailsFragment(investItem)
                )
                viewModel.onDoneNavigatingToDetails()
            }
        }
        return binding.root
    }
    private fun getListOfInvestItems(): List<InvestItem> {
        return listOf(
            InvestItem(0, "Stocks", getString(R.string.stocks_desc), R.drawable.save),
            InvestItem(1, "Bonds", getString(R.string.stocks_desc), R.drawable.save),
            InvestItem(2, "Real Estate", getString(R.string.stocks_desc), R.drawable.save),
            InvestItem(3, "Sacco", getString(R.string.stocks_desc), R.drawable.save),
            InvestItem(4, "Unit Trusts", getString(R.string.stocks_desc), R.drawable.save),
            InvestItem(5, " ETFs", getString(R.string.stocks_desc), R.drawable.save)
        )
    }

}