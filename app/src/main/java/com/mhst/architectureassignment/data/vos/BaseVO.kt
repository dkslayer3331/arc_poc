package com.mhst.architectureassignment.data.vos

data class BaseVO(
    val name : String,
    val description : String,
    val location : String,
    val avgRating : Int,
    val scoresAndReviews : List<ScoreAndReviewVO>,
    val photos : List<PhotoVO>
)