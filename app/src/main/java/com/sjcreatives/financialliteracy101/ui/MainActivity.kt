package com.sjcreatives.financialliteracy101.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sjcreatives.financialliteracy101.R
import com.sjcreatives.financialliteracy101.ui.adapters.LatestReadsAdapter
import com.sjcreatives.financialliteracy101.ui.adapters.ModulesAdapter
import com.sjcreatives.financialliteracy101.databinding.ActivityMainBinding
import com.sjcreatives.financialliteracy101.ui.adapters.ModuleClickListener

class MainActivity : AppCompatActivity() {

    private lateinit var latestReadsAdapter: LatestReadsAdapter
    private lateinit var modulesAdapter: ModulesAdapter
    private  lateinit var mainActivityViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        setupModulesRecyclerview(binding)
        setupLatestReadsRecyclerview(binding)
        /**
         * Observers
         */
        //Reduces boilerplate code related to observers
        binding.lifecycleOwner = this

        mainActivityViewModel.latestReads.observe(this) {
            latestReads -> latestReadsAdapter.submitList(latestReads)
        }

        mainActivityViewModel.learningModules.observe(this) {
            learningModules -> modulesAdapter.submitList(learningModules)
        }

        mainActivityViewModel.navigateToModule.observe(this){
            it?.let {
                Toast.makeText(this,"You just clicked ${it.title}", Toast.LENGTH_SHORT).show()
                mainActivityViewModel.doneNavigatingToModule()
            }

        }


    }
    private fun setupLatestReadsRecyclerview(binding: ActivityMainBinding){
        latestReadsAdapter = LatestReadsAdapter()
        binding.latestReadsRecyclerview.apply {
            adapter = latestReadsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity,
                LinearLayoutManager.HORIZONTAL, false)
        }

    }

    private fun setupModulesRecyclerview(binding: ActivityMainBinding){
        modulesAdapter = ModulesAdapter(ModuleClickListener {module ->
            mainActivityViewModel.onModuleClicked(module)
        })

        binding.modulesRecyclerview.apply {
            adapter = modulesAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

    }

}