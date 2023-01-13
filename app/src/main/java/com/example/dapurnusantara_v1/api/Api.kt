package com.example.dapurnusantara_v1.api

import com.example.dapurnusantara_v1.model.*
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("makanan")
    fun getMakanan(
    ): Call<FoodResponse>

    @GET("login")
    fun checkUserLogin(
        @Query("username")username:String,
        @Query("userpassword")userpassword:String,
    ): Call<LoginResponse>

//    @GET("http://192.168.69.156/online_food_server/public/makanan/{cari}")
    @GET("http://192.168.69.129/online_food_server/public/makanan/{cari}")
    fun getDataSearch(
        @Path("cari")cari:String?=null
    ): Call<FoodResponse>

//    @GET("http://192.168.69.156/online_food_server/public/minuman")
    @GET("http://192.168.69.129/online_food_server/public/minuman")
    fun getDrink(
    ): Call<DrinkResponse>

//    @GET("http://192.168.69.156/online_food_server/public/transaksi")
    @GET("http://192.168.69.129/online_food_server/public/transaksi")
    fun getHistory(
        @Header("Authorization")token_auth:String?,
    ): Call<HistoryResponse>

//    @GET("http://192.168.69.156/online_food_server/public/cart")
    @GET("http://192.168.69.129/online_food_server/public/cart")
    fun getCart(
        @Header("Authorization") token_auth:String?
    ): Call<CartResponse>

    @FormUrlEncoded
//    @POST("http://192.168.215.81/online_food_server/public/transaction")
    @POST("http://192.168.69.129/online_food_server/public/transaction")
    fun createTransaction(
        @Field("item") item:String?,
        @Field("amount") amount:String?,
        @Field("price") price:String?,
        @Field("total_price") totalprice:String?,
        @Field("desc") desc:String?,
        @Field("address") address:String?
    ):Call<CheckoutResponse>
}