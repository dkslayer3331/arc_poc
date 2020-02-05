package com.mhst.architectureassignment.network.dataagents

import com.mhst.architectureassignment.data.vos.BaseVO

interface TravelDataAgent {
    fun getDataLists(onSuccess : (List<BaseVO>)->Unit,onFail : (String)->Unit)
}