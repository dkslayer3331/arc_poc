package com.mhst.architectureassignment.data.models

import com.mhst.architectureassignment.network.dataagents.RetrofitImpl
import com.mhst.architectureassignment.network.dataagents.TravelDataAgent

class BaseModel {

    val mDataAgent : TravelDataAgent = RetrofitImpl

}