package com.mhst.architectureassignment.adapters

import androidx.recyclerview.widget.RecyclerView
import com.mhst.architectureassignment.viewholders.BaseViewHolder

abstract class BaseRecyclerAdapter<W,V : BaseViewHolder<W>> : RecyclerView.Adapter<V>() {

    override fun onBindViewHolder(holder: V, position: Int) {
        //holder.binData()
    }


}