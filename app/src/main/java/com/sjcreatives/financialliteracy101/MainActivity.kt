package com.sjcreatives.financialliteracy101

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.financialliteracy101.adapters.LatestReadsAdapter
import com.sjcreatives.financialliteracy101.databinding.ActivityMainBinding
import com.sjcreatives.financialliteracy101.models.LatestRead

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: LatestReadsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        adapter = LatestReadsAdapter()

        val lr1= LatestRead(0,"Title1",1)
        val lr2= LatestRead(0,"Title1",1)
        val lr3= LatestRead(0,"Title1",1)
        val lr4= LatestRead(0,"Title1",1)

        val latestReadList = listOf(lr1,lr2,lr3,lr4)

        adapter.submitList(latestReadList)

        binding.latestReadsRecyclerview.adapter = adapter
        binding.latestReadsRecyclerview.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false)

    }
}