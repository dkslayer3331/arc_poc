package com.mhst.architectureassignment.network.dataagents

import android.os.AsyncTask
import com.google.gson.Gson
import com.mhst.architectureassignment.BASE_URL
import com.mhst.architectureassignment.GET_ALL
import com.mhst.architectureassignment.NO_CONNECTION_MESSAGE
import com.mhst.architectureassignment.data.vos.BaseVO
import com.mhst.architectureassignment.network.responses.ResponseVO
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

object OkHttpDataAgentImpl : TravelDataAgent {

    private val mClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .build()

    override fun getTours(
        onSuccess: (List<BaseVO>, List<BaseVO>) -> Unit,
        onFail: (String) -> Unit
    ) {

    }

    override fun getCountry(onSuccess: (List<BaseVO>) -> Unit, onFail: (String) -> Unit) {

    }


    class GetNewTask(
        private val mOkHttpClient: OkHttpClient,
        private val mAccessToken: String,
        private val onSuccess: (List<BaseVO>,List<BaseVO>) -> Unit,
        private val onFailure: (String) -> Unit
    ) : AsyncTask<Void, Void, ResponseVO>() {

        override fun doInBackground(vararg p0: Void?): ResponseVO? {

            val request = Request.Builder()
                .url(BASE_URL + GET_ALL)
                .build()

            try {

                val response = mOkHttpClient.newCall(request).execute()

                if(response.isSuccessful){
                    response.body?.let {
                        val responseString = it.toString()
                        return Gson().fromJson(responseString,ResponseVO::class.java)
                    }
                }


            }catch (e : Exception){

            }

            return null

        }

        override fun onPostExecute(result: ResponseVO?) {
            super.onPostExecute(result)
            if (result != null) {
                if (result.isSuccessful()) {
                    result.data?.let {
                        onSuccess(it.country,it.popularTours)
                    }
                } else {
                    onFailure(result.message)
                }
            } else {
                onFailure(NO_CONNECTION_MESSAGE)
            }
        }

    }

}