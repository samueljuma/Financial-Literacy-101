package com.sjcreatives.financialliteracy101.ui.debt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.DebtItem

class DebtViewModel : ViewModel(){

    private val _listOfDebtItems = MutableLiveData<List<DebtItem?>>()
    val listOfDebtItems : LiveData<List<DebtItem?>>  = _listOfDebtItems

    fun setListOfDebtItems(list: List<DebtItem>){
        _listOfDebtItems.value = list
    }
}