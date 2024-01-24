package com.sjcreatives.financialliteracy101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.financialliteracy101.adapters.LatestReadsAdapter
import com.sjcreatives.financialliteracy101.adapters.ModulesAdapter
import com.sjcreatives.financialliteracy101.databinding.ActivityMainBinding
import com.sjcreatives.financialliteracy101.models.LatestRead
import com.sjcreatives.financialliteracy101.models.LearningModule

class MainActivity : AppCompatActivity() {

    private lateinit var latestReadsAdapter: LatestReadsAdapter
    private lateinit var modulesAdapter: ModulesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        latestReadsAdapter = LatestReadsAdapter()

        val lr1= LatestRead(0,"Title1",1)
        val lr2= LatestRead(0,"Title1",1)
        val lr3= LatestRead(0,"Title1",1)
        val lr4= LatestRead(0,"Title1",1)

        val latestReadList = listOf(lr1,lr2,lr3,lr4)

        latestReadsAdapter.submitList(latestReadList)

        binding.latestReadsRecyclerview.adapter = latestReadsAdapter
        binding.latestReadsRecyclerview.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)

        modulesAdapter = ModulesAdapter()

        val module1 = LearningModule(0,"Investing", "Let's Invest")
        val module2 = LearningModule(0,"Investing", "Let's Invest")
        val module3 = LearningModule(0,"Investing", "Let's Invest")
        val module4 = LearningModule(0,"Investing", "Let's Invest")
        val module5 = LearningModule(0,"Investing", "Let's Invest")
        val module6 = LearningModule(0,"Investing", "Let's Invest")

        val modulesList = listOf(module1, module2, module3, module4, module5, module6)

        modulesAdapter.submitList(modulesList)

        binding.modulesRecyclerview.adapter = modulesAdapter
        binding.modulesRecyclerview.layoutManager = GridLayoutManager(this, 2)

    }
}