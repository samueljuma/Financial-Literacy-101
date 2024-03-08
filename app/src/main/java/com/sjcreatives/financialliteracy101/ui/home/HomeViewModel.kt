package com.sjcreatives.financialliteracy101.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.LatestRead
import com.sjcreatives.financialliteracy101.data.models.LearningModule

class HomeViewModel : ViewModel() {

    private val _latestReads = MutableLiveData<List<LatestRead>>()
    val latestReads: LiveData<List<LatestRead>> = _latestReads

    private val _learningModules = MutableLiveData<List<LearningModule>>()
    val learningModules: LiveData<List<LearningModule>> = _learningModules

    fun setLatestReads(list:List<LatestRead>) {
        _latestReads.value = list
    }

    fun setModules(list: List<LearningModule>) {
        _learningModules.value = list
    }

    private val _navigateToModule = MutableLiveData<LearningModule?>()
    val navigateToModule: LiveData<LearningModule?> = _navigateToModule

    fun onModuleClicked(module: LearningModule){
        _navigateToModule.value = module
    }

    fun doneNavigatingToModule (){
        _navigateToModule.value = null
    }

    private val _navigateToLatestRead = MutableLiveData<LatestRead?>()
    val navigateToLatestRead: LiveData<LatestRead?> = _navigateToLatestRead

    fun onLatestReadClicked (latestRead: LatestRead){
        _navigateToLatestRead.value = latestRead
    }

    fun doneNavigatingToLatestRead(){
        _navigateToLatestRead.value = null
    }
}