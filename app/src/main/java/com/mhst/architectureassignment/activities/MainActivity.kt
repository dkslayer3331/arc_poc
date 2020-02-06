package com.mhst.architectureassignment.activities

import android.os.Bundle
import android.util.Log
import com.mhst.architectureassignment.R
import com.mhst.architectureassignment.adapters.CountryAdapter
import com.mhst.architectureassignment.data.models.TourModel
import com.mhst.architectureassignment.data.models.TourModelImpl

class MainActivity : BaseActivity() {

    lateinit var countryAdapter: CountryAdapter

    val tourModel :TourModel = TourModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryAdapter = CountryAdapter {
            Log.d("countryPosition",it.toString())
        }

        tourModel.getAllList(onSucess = {
            list, list2 ->
            Log.d("","")
        },onFail = {
            s -> Log.d("error",s)
        })



    }
}
