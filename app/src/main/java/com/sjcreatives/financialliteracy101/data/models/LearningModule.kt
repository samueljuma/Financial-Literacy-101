package com.sjcreatives.financialliteracy101.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize // Important especially for passing models as arguments in the nav_graph -> Be sure to add kotlin-parcelize as plugin in gradle
data class LearningModule (
    val id: Int,
    val title: String,
    val image: Int
): Parcelable