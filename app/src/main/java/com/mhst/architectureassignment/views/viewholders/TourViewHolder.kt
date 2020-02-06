package com.mhst.architectureassignment.views.viewholders

import android.view.TouchDelegate
import android.view.View
import com.mhst.architectureassignment.data.vos.BaseVO

class TourViewHolder(itemView: View,val delegate: (Int)->Unit) : BaseViewHolder<BaseVO>(itemView) {
    override fun binData(data: BaseVO?) {
        itemView.setOnClickListener {
            delegate(adapterPosition)
        }
    }
}