package com.mhst.architectureassignment.views.viewpods

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.rating_viewpod.view.*

class FavViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setValues(score : Float){
        tvRating.text = score.toString()
        //vpFav.setBackgroundDrawable(drawable)
    }

}