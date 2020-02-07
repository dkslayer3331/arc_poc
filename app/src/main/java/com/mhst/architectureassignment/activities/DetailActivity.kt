package com.mhst.architectureassignment.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.architectureassignment.R

class DetailActivity : BaseActivity() {

    companion object{
        private const val IE_ID = "Id"

        fun newInstance(context: Context,id : Int) : Intent{
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra(IE_ID,id)
            return intent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



    }
}
