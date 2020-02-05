package com.mhst.architectureassignment.activities

import android.os.Bundle
import android.util.Log
import com.mhst.architectureassignment.R
import com.mhst.architectureassignment.adapters.CountryAdapter

class MainActivity : BaseActivity() {

    lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryAdapter = CountryAdapter {
            Log.d("countryPosition",it.toString())
        }



    }
}
