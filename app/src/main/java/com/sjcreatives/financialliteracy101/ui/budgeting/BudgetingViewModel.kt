package com.sjcreatives.financialliteracy101.ui.budgeting

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.BudgetItem

class BudgetingViewModel: ViewModel() {
    private val _listOfBudgetItems = MutableLiveData<List<BudgetItem>>()
    val listOfBudgetItems : LiveData<List<BudgetItem>> = _listOfBudgetItems

    fun setBudgetItems(list: List<BudgetItem>){
        _listOfBudgetItems.value = list
    }
}