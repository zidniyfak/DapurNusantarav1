package com.example.dapurnusantara_v1.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.databinding.ActivityCheckoutBinding
import com.example.dapurnusantara_v1.model.CheckoutResponse
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_food_detail.*
import kotlinx.android.synthetic.main.toolbar.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding
    private var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val foodName = intent.getStringExtra("FoodName")
        tvCheckoutItemTitle.text = foodName

        btnPlus.setOnClickListener{
            value++
            tvAmount.text = value.toString()

        }
        btnMinus.setOnClickListener{
            value--
            tvAmount.text = value.toString()

        }

        binding.btnCheckoutEnd.setOnClickListener {
            saveTransaction()

        }


        btnMaps.setOnClickListener{
            val intent = Intent(this, MapsActivity2::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.tbSettings -> {
                Toast.makeText(this, "Aplikasi di klik", Toast.LENGTH_LONG).show()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    fun saveTransaction(){
        with(binding){
            val item = tvCheckoutItemTitle.text.toString()
            val amount = tvAmount.text.toString()
            val price = tvCheckoutItemPrice.text.toString()
            val address = tvAddress.text.toString()
            val totalprice = tvTotalCheckout.text.toString()
            val desc = tvNotes.text.toString()

            RClient.instance.createTransaction(item,amount,price,address,totalprice,desc).enqueue(object :Callback<CheckoutResponse>{
                override fun onResponse(
                    call: Call<CheckoutResponse>,
                    response: Response<CheckoutResponse>
                ) {
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext,"${response.body()?.msg}",Toast.LENGTH_LONG).show()
                        finish()
                    }else{
                        val jsonObj = JSONObject(response.errorBody()!!.charStream().readText())
                        tvAddress.setError(jsonObj.getString("message"))
                    }
                }

                override fun onFailure(call: Call<CheckoutResponse>, t: Throwable) {
                }
            })
        }
    }
}