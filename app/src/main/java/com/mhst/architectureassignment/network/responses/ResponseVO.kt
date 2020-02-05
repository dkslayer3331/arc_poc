package com.mhst.architectureassignment.network.responses

import com.mhst.architectureassignment.data.vos.DataVO

data class ResponseVO(
    val code: Int,
    val message: String,
    val data: DataVO
)