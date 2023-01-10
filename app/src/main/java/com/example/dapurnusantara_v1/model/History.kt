package com.example.dapurnusantara_v1.model

import com.google.gson.annotations.SerializedName

data class History (
    val status:String,

    @SerializedName("id_pelanggan")
    val id:Int,

    @SerializedName("created_at")
    val date:Int,

    @SerializedName("total_bayar")
    val total:Int
)