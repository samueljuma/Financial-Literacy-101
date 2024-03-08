package com.sjcreatives.financialliteracy101.ui.saving

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.data.models.SavingItem

class SavingViewModel:ViewModel() {

    private val _listOfSavingItems = MutableLiveData<List<SavingItem>>()
    val listOfSavingItems: LiveData<List<SavingItem>> =_listOfSavingItems

    fun setSavingItems (list: List<SavingItem>){
        _listOfSavingItems.value = list
    }
}