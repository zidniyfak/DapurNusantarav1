package com.example.dapurnusantara_v1.model

import com.google.gson.annotations.SerializedName

class Cart (
    val id:Int,
    val item:String,
    val amount:Int,
    val price:Int,
    @SerializedName("total_price")
    val total:Int,
)