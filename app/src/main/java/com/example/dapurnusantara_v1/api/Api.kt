package com.example.dapurnusantara_v1.api

import com.example.dapurnusantara_v1.model.FoodResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("makanan")
    fun getMakanan(
    ): Call<FoodResponse>
}