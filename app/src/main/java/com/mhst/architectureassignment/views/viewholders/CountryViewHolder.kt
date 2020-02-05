package com.mhst.architectureassignment.views.viewholders

import android.view.View
import com.mhst.architectureassignment.data.vos.BaseVO
import kotlinx.android.synthetic.main.rv_country_item.view.*

class CountryViewHolder(itemView: View,val delegate : (id : Int)->Unit) : BaseViewHolder<BaseVO>(itemView) {
    override fun binData(data: BaseVO?) {
        //todo : country viewholder impl
        itemView.tvCountryName.text = data?.name ?: "Not avail"
        itemView.setOnClickListener {
            delegate.invoke(adapterPosition)
        }
    }
}