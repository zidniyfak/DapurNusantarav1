package com.example.dapurnusantara_v1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapurnusantara_v1.R
import kotlinx.android.synthetic.main.activity_food_detail.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val foodName = intent.getStringExtra("FoodName")
        tvDetail.text = foodName

        tvAppBar.text = "Detail Makanan"

        btnCheckout.setOnClickListener{
            val intent = Intent(this,CheckoutActivity::class.java)
            intent.putExtra("FoodName", foodName)
            startActivity(intent)
        }
    }
}