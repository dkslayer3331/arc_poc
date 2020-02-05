package com.mhst.architectureassignment.data.vos

data class ScoreAndReviewVO(
    val name : String,
    val score : Int,
    val maxScore : Int,
    val totalReviews : Int
)