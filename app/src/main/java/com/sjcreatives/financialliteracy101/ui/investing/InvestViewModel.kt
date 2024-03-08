package com.sjcreatives.financialliteracy101.ui.investing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.R
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


    private val _listOfInvestItems = MutableLiveData<List<InvestItem?>>()
    val listOfInvestItems: LiveData<List<InvestItem?>> = _listOfInvestItems

    fun setInvestItems(listOfInvestItems: List<InvestItem>){
        _listOfInvestItems.value = listOfInvestItems
    }

}