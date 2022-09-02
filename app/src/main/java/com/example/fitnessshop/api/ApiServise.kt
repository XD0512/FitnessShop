package com.example.fitnessshop.api

import com.example.newproject.util.Constant
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiServise {

    var retrofit:Retrofit? = null
    var api:Api? = null


    fun apiSports():Api{
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
        return retrofit!!.create(Api::class.java)
    }
  /*  fun apiNews():Api {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()

            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }*/
}