package com.mhst.architectureassignment.views.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.mhst.architectureassignment.data.vos.BaseVO
import com.mhst.architectureassignment.views.viewpods.FavViewPod
import kotlinx.android.synthetic.main.rv_country_item.view.*

class CountryViewHolder(itemView: View,val delegate : (id : Int)->Unit) : BaseViewHolder<BaseVO>(itemView) {
    override fun binData(data: BaseVO?) {

        val vp = itemView.vpFavCountry as FavViewPod

        itemView.tvCountryName.text = data?.name ?: "Not avail"

        Glide.with(itemView.context).load(data?.photos?.get(0)).into(itemView.ivCountryImage)

        vp.setValues(data?.avgRating ?: 0f)

        itemView.setOnClickListener {
            delegate.invoke(adapterPosition)
        }
    }
}