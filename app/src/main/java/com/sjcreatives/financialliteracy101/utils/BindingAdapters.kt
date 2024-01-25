package com.sjcreatives.financialliteracy101.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("android:src")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}

