package com.mhst.architectureassignment.network.dataagents

import com.mhst.architectureassignment.BASE_URL
import com.mhst.architectureassignment.NO_CONNECTION_MESSAGE
import com.mhst.architectureassignment.data.vos.BaseVO
import com.mhst.architectureassignment.network.TravelApi
import com.mhst.architectureassignment.network.responses.ResponseVO
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitImpl : TravelDataAgent {

    private var travelApi : TravelApi? = null

    init {
        val okHttpBuilder = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder)
            .build()

        travelApi = retrofit.create(TravelApi::class.java)
    }


    override fun getTours(
        onSuccess: (List<BaseVO>, List<BaseVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        travelApi?.getAllTours()?.enqueue(object :Callback<ResponseVO>{
            override fun onFailure(call: Call<ResponseVO>, t: Throwable) {
                onFail(t.localizedMessage ?: NO_CONNECTION_MESSAGE)
            }

            override fun onResponse(call: Call<ResponseVO>, response: Response<ResponseVO>) {
                    response.body()?.let {
                        it.data?.let {
                            onSuccess(it.country,it.popularTours)
                        }
                    } ?: onFail("no data")
            }

        })
    }

    override fun getCountry(onSuccess: (List<BaseVO>) -> Unit, onFail: (String) -> Unit) {

    }
}