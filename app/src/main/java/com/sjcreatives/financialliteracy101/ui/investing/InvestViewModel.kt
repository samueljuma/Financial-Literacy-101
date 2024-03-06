package com.sjcreatives.financialliteracy101.ui.investing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.InvestItem

class InvestViewModel : ViewModel(){
    private val _navigateToDetails = MutableLiveData<InvestItem?>()
    val navigateToDetails: LiveData<InvestItem?> = _navigateToDetails

    fun onInvestItemClicked (investItem: InvestItem){
        _navigateToDetails.value = investItem
    }
    fun onDoneNavigatingToDetails (){
        _navigateToDetails.value = null
    }

}