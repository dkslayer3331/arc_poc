package com.mhst.architectureassignment.activities

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    fun showMessage(message : String){
        Snackbar.make(window.decorView,message,Snackbar.LENGTH_LONG).show()
    }


}