package com.example.dapurnusantara_v1.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.activity.FoodDetailActivity
import com.example.dapurnusantara_v1.adapter.MakananAdapter
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.model.Food
import com.example.dapurnusantara_v1.model.FoodResponse
import kotlinx.android.synthetic.main.food_item.*
import kotlinx.android.synthetic.main.fragment_menu_makanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuMakananFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var list = ArrayList<Food>()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu_makanan, container, false)

        recyclerView = view.findViewById(R.id.rvMenuMakanan)
        showFood()

//        cardView = view.findViewById<CardView>(R.id.cvFoodI

        return view
    }

    private fun showFood() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        RClient.instance.getMakanan().enqueue(object : Callback<FoodResponse>{
            override fun onResponse(call: Call<FoodResponse>, response: Response<FoodResponse>) {
                // Karena dalamnya ada json object ditambahin .data
                val listResponse = response.body()?.data

                listResponse?.let { list.addAll(it) }
                val adapter = MakananAdapter(list)

                rvMenuMakanan.adapter = adapter
            }

            override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                Log.d("APIERROR", t.message.toString())
            }
        })
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        cvFoodItem.setOnClickListener{
//            val intent = Intent(activity,FoodDetailActivity::class.java)
//            startActivity(intent)
//        }
//        super.onViewCreated(view, savedInstanceState)
//    }
}