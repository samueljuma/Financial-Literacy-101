package com.sjcreatives.financialliteracy101.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.ui.adapters.LatestReadsAdapter
import com.sjcreatives.financialliteracy101.ui.adapters.ModulesAdapter
import com.sjcreatives.financialliteracy101.databinding.ActivityMainBinding
import com.sjcreatives.financialliteracy101.data.models.LatestRead
import com.sjcreatives.financialliteracy101.data.models.LearningModule
import com.sjcreatives.financialliteracy101.data.repositories.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var latestReadsAdapter: LatestReadsAdapter
    private lateinit var modulesAdapter: ModulesAdapter
    private  lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setupModulesRecyclerview(binding)
        setupLatestReadsRecyclerview(binding)
        /**
         * Observers
         */
        mainActivityViewModel.latestReads.observe(this) {
            latestReads -> latestReadsAdapter.submitList(latestReads)
        }
//
        mainActivityViewModel.learningModules.observe(this) {
            learningModules -> modulesAdapter.submitList(learningModules)
        }


    }
    private fun setupLatestReadsRecyclerview(binding: ActivityMainBinding){
        latestReadsAdapter = LatestReadsAdapter()
        binding.latestReadsRecyclerview.apply {
            adapter = latestReadsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.HORIZONTAL, false)
        }

    }

    private fun setupModulesRecyclerview(binding: ActivityMainBinding){
        modulesAdapter = ModulesAdapter()
        binding.modulesRecyclerview.apply {
            adapter = modulesAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

    }

}