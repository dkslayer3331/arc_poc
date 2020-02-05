package com.mhst.architectureassignment.network

import com.mhst.architectureassignment.GET_ALL
import com.mhst.architectureassignment.network.responses.ResponseVO
import retrofit2.Call
import retrofit2.http.GET

interface TravelApi {

    @GET(GET_ALL)
    fun getAllTours() : Call<ResponseVO>

}