package com.mhst.architectureassignment.data.models

import com.mhst.architectureassignment.data.vos.BaseVO

object TourModelImpl : TourModel, BaseModel() {

    override fun getCountry(id: Int): BaseVO  = countryList[id] ?: BaseVO()

    override fun getTourDetail(id: Int): BaseVO = tourList[id] ?: BaseVO()

    private val tourList : HashMap<Int,BaseVO> = hashMapOf()

    private val countryList : HashMap<Int,BaseVO> = hashMapOf()

    override fun getAllList(
        onSucess: (List<BaseVO>, List<BaseVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mDataAgent.getTours(onSuccess = {countries, tours ->
          countries.forEachIndexed {index,it->
              tourList[index] = it
          }
          tours.forEachIndexed { index, baseVO ->
              countryList[index] = baseVO
          }
            onSucess.invoke(countries,tours)
        },onFail = {
                onFail.invoke(it)
        })
    }


}