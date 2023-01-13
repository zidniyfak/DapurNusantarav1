package com.example.dapurnusantara_v1.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dapurnusantara_v1.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_food_detail.*
import kotlinx.android.synthetic.main.food_item.view.*
import kotlinx.android.synthetic.main.toolbar.*

class FoodDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        tvNameFood.text = intent.getStringExtra("FoodName")
        tvDescFood.text = intent.getStringExtra("FoodDesc")
        tvPriceDetail.text = intent.getStringExtra("FoodPrice")
        Picasso.get().load("https://images.tokopedia.net/img/KRMmCm/2022/8/9/51584c5e-2713-4895-88d5-30b677255ffd.jpg").fit().centerCrop().into(ivDetailFood)

        tvAppBar.text = "Detail Makanan"

        btnCheckout.setOnClickListener{
            val intent = Intent(this,CheckoutActivity::class.java)
            intent.putExtra("FoodName", intent.getStringExtra("FoodName"))
            startActivity(intent)
        }
    }
}