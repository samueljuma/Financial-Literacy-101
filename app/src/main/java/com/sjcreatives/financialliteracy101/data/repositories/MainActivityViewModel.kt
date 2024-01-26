package com.sjcreatives.financialliteracy101.data.repositories

import androidx.lifecycle.ViewModel
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.data.models.LatestRead

class MainActivityViewModel: ViewModel() {

    fun getLatestReadsList(): List<LatestRead> {
        val lr1 = LatestRead(0, "Title1", R.drawable.read1)
        val lr2 = LatestRead(0, "Title1", R.drawable.read2)
        val lr3 = LatestRead(0, "Title1", R.drawable.read3)
        val lr4 = LatestRead(0, "Title1", R.drawable.read4)

        return listOf(lr1, lr2, lr3, lr4)
    }

}