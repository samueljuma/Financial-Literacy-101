package com.sjcreatives.financialliteracy101.ui.tax

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.TaxItem

class TaxViewModel: ViewModel() {

    private val _listOfTaxItems = MutableLiveData<List<TaxItem?>>()
    val listOfTaxItems: LiveData<List<TaxItem?>> = _listOfTaxItems

    fun setListOfTaxItems(list: List<TaxItem>){
       _listOfTaxItems.value = list
    }
}