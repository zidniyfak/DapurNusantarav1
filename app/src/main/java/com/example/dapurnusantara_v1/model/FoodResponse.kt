package com.example.dapurnusantara_v1.model

import com.google.gson.annotations.SerializedName

data class FoodResponse (
    val data : ArrayList<Food>
)
data class Food (
    @SerializedName("id_food")
    val idf:Int,
    @SerializedName("name_food")
    val name:String,
    @SerializedName("price_food")
    val price:Int,
    @SerializedName("desc_food")
    val desc:String,
    @SerializedName("pict_food")
    val pict:String,
)
