package com.mhst.architectureassignment.data.models

import com.mhst.architectureassignment.data.vos.BaseVO

object TourModelImpl : TourModel, BaseModel() {

    override fun getCountry(id: Int): BaseVO  = countryList[id] ?: BaseVO()

    override fun getTourDetail(id: Int): BaseVO = tourList[id] ?: BaseVO()

     val tourList : HashMap<Int,BaseVO> = hashMapOf()

     val countryList : HashMap<Int,BaseVO> = hashMapOf()

    override fun getAllList(
        onSucess: (List<BaseVO>, List<BaseVO>) -> Unit,
        onFail: (String) -> Unit
    ) {
        mDataAgent.getTours(onSuccess = {countries, tours ->
          countries.forEachIndexed {index,it->
              countryList[index] = it
          }
          tours.forEachIndexed { index, baseVO ->
              tourList[index] = baseVO
          }
            onSucess.invoke(countries,tours)
        },onFail = {
                onFail.invoke(it)
        })
    }


}