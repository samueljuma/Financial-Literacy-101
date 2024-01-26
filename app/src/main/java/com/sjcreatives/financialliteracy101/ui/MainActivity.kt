package com.sjcreatives.financialliteracy101.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
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
    private lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

        latestReadsAdapter = LatestReadsAdapter()

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        latestReadsAdapter.submitList(mainActivityViewModel.getLatestReadsList())

        binding.latestReadsRecyclerview.adapter = latestReadsAdapter
        binding.latestReadsRecyclerview.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)

        modulesAdapter = ModulesAdapter()

        val module1 = LearningModule(0,"Saving", R.drawable.save)
        val module2 = LearningModule(0,"Investing", R.drawable.invest)
        val module3 = LearningModule(0,"Budgeting", R.drawable.budget)
        val module4 = LearningModule(0,"Insurance", R.drawable.insurance)
        val module5 = LearningModule(0,"Debt/Credit", R.drawable.credit_debt)
        val module6 = LearningModule(0,"Tax", R.drawable.tax)

        val modulesList = listOf(module1, module2, module3, module4, module5, module6)

        modulesAdapter.submitList(modulesList)

        binding.modulesRecyclerview.adapter = modulesAdapter
        binding.modulesRecyclerview.layoutManager = GridLayoutManager(this, 2)

    }
}