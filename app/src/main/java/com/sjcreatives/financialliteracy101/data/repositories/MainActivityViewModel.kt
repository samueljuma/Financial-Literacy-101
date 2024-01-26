package com.sjcreatives.financialliteracy101.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.LatestRead
import com.sjcreatives.financialliteracy101.data.models.LearningModule

class MainActivityViewModel: ViewModel() {

    private val _latestReads = MutableLiveData<List<LatestRead>>()
    val latestReads: LiveData<List<LatestRead>> = _latestReads

    private val _learningModules = MutableLiveData<List<LearningModule>>()
    val learningModules: LiveData<List<LearningModule>> = _learningModules
    init {
        loadLatestReads()
        loadModules()
    }

    private fun loadLatestReads() {

        val lr1 = LatestRead(0, "Title1", R.drawable.read1)
        val lr2 = LatestRead(0, "Title1", R.drawable.read2)
        val lr3 = LatestRead(0, "Title1", R.drawable.read3)
        val lr4 = LatestRead(0, "Title1", R.drawable.read4)

        _latestReads.value = listOf(lr1, lr2, lr3, lr4)
    }

    private fun loadModules() {
        val module1 = LearningModule(0,"Saving", R.drawable.save)
        val module2 = LearningModule(0,"Investing", R.drawable.invest)
        val module3 = LearningModule(0,"Budgeting", R.drawable.budget)
        val module4 = LearningModule(0,"Insurance", R.drawable.insurance)
        val module5 = LearningModule(0,"Debt/Credit", R.drawable.credit_debt)
        val module6 = LearningModule(0,"Tax", R.drawable.tax)

        _learningModules.value = listOf(module1, module2, module3, module4, module5, module6)
    }



}