package com.mhst.architectureassignment.data.vos

data class BaseVO(
    val name : String = "",
    val description : String = "",
    val location : String = "",
    val avgRating : Int = 0,
    val scoresAndReviews : List<ScoreAndReviewVO> = listOf(),
    val photos : List<PhotoVO> = listOf()
)