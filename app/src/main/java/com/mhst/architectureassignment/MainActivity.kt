package com.mhst.architectureassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mhst.architectureassignment.activities.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
