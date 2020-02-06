package com.mhst.architectureassignment.data.models

import com.mhst.architectureassignment.network.dataagents.RetrofitImpl
import com.mhst.architectureassignment.network.dataagents.TravelDataAgent

abstract class BaseModel {

    val mDataAgent : TravelDataAgent = RetrofitImpl

}