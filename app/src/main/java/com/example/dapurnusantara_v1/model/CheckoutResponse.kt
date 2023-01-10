package com.example.dapurnusantara_v1.model

import com.google.gson.annotations.SerializedName

data class CheckoutResponse (
   @SerializedName("status")
   val stt:Int,

   @SerializedName("error")
   val e:Boolean,

   @SerializedName("message")
   val msg:String
)