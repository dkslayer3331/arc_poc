package com.mhst.architectureassignment.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.mhst.architectureassignment.R
import com.mhst.architectureassignment.adapters.CountryAdapter
import com.mhst.architectureassignment.adapters.TourAdapter
import com.mhst.architectureassignment.data.models.TourModel
import com.mhst.architectureassignment.data.models.TourModelImpl
import com.mhst.architectureassignment.data.vos.BaseVO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    lateinit var countryAdapter: CountryAdapter

    lateinit var tourAdapter: TourAdapter

    val tourModel: TourModel = TourModelImpl

    private fun requestData() {
        swipeRefresh.isRefreshing = true
        tourModel.getAllList(onSucess = { countries, tours ->
            swipeRefresh.isRefreshing = false
            tourAdapter.setNewData(tours.toMutableList())
            countryAdapter.setNewData(countries.toMutableList())

        }, onFail = {
            swipeRefresh.isRefreshing = false
            showMessage(it)
        })
    }

    private fun setupRecyclers() {
        rvTours.adapter = tourAdapter
        rvCountry.adapter = countryAdapter
    }

    private fun setupSwipeRefresh() {
        swipeRefresh.setOnRefreshListener {
            requestData()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSwipeRefresh()

        requestData()

        countryAdapter = CountryAdapter {
            Log.d("countryPosition", it.toString())
            val intent = DetailActivity.newInstance(this,it)
            startActivity(intent)
        }

        tourAdapter = TourAdapter {
            val intent = DetailActivity.newInstance(this,it)
            startActivity(intent)
        }

        setupRecyclers()

    }
}
