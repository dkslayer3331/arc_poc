package com.mhst.architectureassignment.network.dataagents

import com.mhst.architectureassignment.data.vos.BaseVO

interface TravelDataAgent {
    fun getTours(onSuccess : (List<BaseVO>,List<BaseVO>)->Unit,onFail : (String)->Unit)
    fun getCountry(onSuccess: (List<BaseVO>) -> Unit,onFail: (String) -> Unit)
}