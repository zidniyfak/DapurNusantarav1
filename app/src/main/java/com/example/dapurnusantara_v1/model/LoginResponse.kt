package com.example.dapurnusantara_v1.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status") val stt:Int,
    @SerializedName("error") val err:Int,
    @SerializedName("messages") val msg:String,
    val token:String,
    val username:String,
    val email:String,
)
