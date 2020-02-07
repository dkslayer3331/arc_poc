package com.mhst.architectureassignment.activities

import android.content.AbstractThreadedSyncAdapter
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.mhst.architectureassignment.R
import com.mhst.architectureassignment.adapters.PhotoAdapter
import com.mhst.architectureassignment.adapters.ReviewAdapter
import com.mhst.architectureassignment.data.models.TourModel
import com.mhst.architectureassignment.data.models.TourModelImpl
import com.mhst.architectureassignment.data.vos.BaseVO
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    lateinit var scoreAndReviewAdapter: ReviewAdapter

    lateinit var photoAdapter: PhotoAdapter

    val model : TourModel = TourModelImpl

    var data = BaseVO()

    companion object{
        private const val IE_ID = "Id"
        private const val IE_TYPE = "Type"  // country -> 1 , tour -> 2

        fun newInstance(context: Context,id : Int,type : Int) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(IE_ID,id)
            intent.putExtra(IE_TYPE,type)
            return intent
        }

    }

    private fun setUpRecycler(){
        scoreAndReviewAdapter = ReviewAdapter()
        photoAdapter = PhotoAdapter()
        rvScoreAndReview.adapter = scoreAndReviewAdapter
        rvPhotos.adapter = photoAdapter
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getIntExtra(IE_ID,0)

        val type = intent.getIntExtra(IE_TYPE,0)

        data = if(type == 1) model.getCountry(id) else model.getTourDetail(id)

        setUpRecycler()

        tvTourHeading.text = data.name

        tvLocationName.text = data.location

        tvDesc.text = data.description

        Glide.with(this).load(data.photos[0]).into(ivBgImage)

        ratingBar.rating = data?.avgRating

        tvRating.text = data?.avgRating.toString()

        scoreAndReviewAdapter.setNewData(data.scoresAndReviews.toMutableList())

        photoAdapter.setNewData(data.photos.toMutableList())

    }
}
