package com.example.dapurnusantara_v1.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RClient {
//    private const val BASE_URL = "http://192.168.69.156/online_food_server/public/"
//    private const val BASE_URL = "http://192.168.215.81/online_food_server/public/"  //IP Phone
//    private const val BASE_URL = "http://10.113.105.199/online_food_server/public/"  //IP Phone
    private const val BASE_URL = "http://192.168.69.129/online_food_server/public/"  //IP Phone

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}