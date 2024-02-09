package com.sjcreatives.financialliteracy101.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.financialliteracy101.data.models.LearningModule
import com.sjcreatives.financialliteracy101.databinding.FragmentHomeBinding
import com.sjcreatives.financialliteracy101.ui.adapters.LatestReadClickListener
import com.sjcreatives.financialliteracy101.ui.adapters.LatestReadsAdapter
import com.sjcreatives.financialliteracy101.ui.adapters.ModuleClickListener
import com.sjcreatives.financialliteracy101.ui.adapters.ModulesAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var latestReadsAdapter: LatestReadsAdapter
    private lateinit var modulesAdapter: ModulesAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        setupLatestReadsRecyclerview(binding)
        setupModulesRecyclerview(binding)

        subscribeUI(latestReadsAdapter,modulesAdapter)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.navigateToModule.observe(viewLifecycleOwner){ module ->
            module?.let {

                when(module.title){
                    "Saving" -> navigateToSavingsModuleScreen()
                    "Investing" -> navigateToInvestmentModuleScreen()
                    "Budgeting" -> navigateTOBudgetingModuleScreen()
                    "Insurance" -> navigateTOInsuranceModuleScreen()
                    "Debt/Credit" -> navigateTODebtModuleScreen()
                    "Tax" -> navigateTOTaxModuleScreen()
                    else -> Toast.makeText(context, "Oops! ${module.title} Not Found",Toast.LENGTH_SHORT).show()

                }
                homeViewModel.doneNavigatingToModule()
            }
        }
        homeViewModel.navigateToLatestRead.observe(viewLifecycleOwner){ latestRead ->
            latestRead?.let {
                this.findNavController().navigate(
                    HomeFragmentDirections.actionHomeFragmentToLatestReadFragment()
                )
                Toast.makeText(context, "Hello ${latestRead.title}", Toast.LENGTH_SHORT).show()
                homeViewModel.doneNavigatingToLatestRead()
            }
        }

    }

    private fun navigateTOBudgetingModuleScreen() {
        this.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToBudgetingFragment()
        )
    }

    private fun navigateTOInsuranceModuleScreen() {
        this.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToInsuranceFragment()
        )
    }
    private fun navigateTODebtModuleScreen() {
        this.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToDebtFragment()
        )
    }
    private fun navigateTOTaxModuleScreen() {
        this.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToTaxFragment()
        )
    }

    private fun navigateToInvestmentModuleScreen() {
        this.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToInvestingFragment()
        )
    }

    private fun navigateToSavingsModuleScreen() {
        this.findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToSavingFragment()
        )
    }

    private fun setupModulesRecyclerview (binding: FragmentHomeBinding){
        modulesAdapter = ModulesAdapter(ModuleClickListener { module ->
            homeViewModel.onModuleClicked(module)
        })
        binding.modulesRecyclerview.apply {
            adapter = modulesAdapter
            layoutManager = GridLayoutManager(context, 2)
        }
    }

    private fun setupLatestReadsRecyclerview(binding: FragmentHomeBinding){
        latestReadsAdapter = LatestReadsAdapter(LatestReadClickListener {latestRead ->
            homeViewModel.onLatestReadClicked(latestRead)
        })
        binding.latestReadsRecyclerview.apply {
            adapter = latestReadsAdapter
            layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.HORIZONTAL, false)
        }

    }

    private fun subscribeUI(
        latestReadsAdapter: LatestReadsAdapter,
        modulesAdapter: ModulesAdapter){

        homeViewModel.latestReads.observe(viewLifecycleOwner){ latestReads ->
            latestReads?.apply {
                latestReadsAdapter.submitList(latestReads)
            }

        }
        homeViewModel.learningModules.observe(viewLifecycleOwner){ modules ->
            modules?.apply {
                modulesAdapter.submitList(modules)
            }
        }

    }


}