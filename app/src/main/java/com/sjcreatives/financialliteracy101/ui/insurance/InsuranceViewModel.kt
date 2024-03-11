package com.sjcreatives.financialliteracy101.ui.insurance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.InsuranceItem

class InsuranceViewModel: ViewModel() {

    private val _listOfInsuranceItems = MutableLiveData<List<InsuranceItem?>>()
    val listOfInsuranceItems: LiveData<List<InsuranceItem?>> = _listOfInsuranceItems

    fun setListOfInsuranceItems(list: List<InsuranceItem>){
        _listOfInsuranceItems.value = list
    }
}