package com.sjcreatives.financialliteracy101.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InvestItem(
    val id: Int,
    val title: String,
    val desc: String,
    val image: Int
): Parcelable
