package com.sjcreatives.financialliteracy101.ui.investing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.InvestItem

class InvestItemDetailsViewModel: ViewModel() {

    private val _investItem = MutableLiveData<InvestItem?>()

    val investItem: LiveData<InvestItem?> = _investItem

    fun setInvestItem (investItem: InvestItem){
        _investItem.value = investItem
    }


}