package com.example.dapurnusantara_v1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.adapter.DrinkAdapter
import com.example.dapurnusantara_v1.adapter.MakananAdapter
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.model.Drink
import com.example.dapurnusantara_v1.model.DrinkResponse
import com.example.dapurnusantara_v1.model.Food
import com.example.dapurnusantara_v1.model.FoodResponse
import kotlinx.android.synthetic.main.fragment_menu_makanan.*
import kotlinx.android.synthetic.main.fragment_menu_minuman.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuMinumanFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private var list = ArrayList<Drink>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu_minuman, container, false)
        recyclerView = view.findViewById(R.id.rvDrinkList)
        showDrink()
        return view
    }

    private fun showDrink() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(activity,2)
        RClient.instance.getDrink().enqueue(object : Callback<DrinkResponse> {

            override fun onResponse(call: Call<DrinkResponse>, response: Response<DrinkResponse>) {
                // Karena dalamnya ada json object ditambahin .data
                val listResponse = response.body()?.data

                listResponse?.let { list.addAll(it) }
                val adapter = DrinkAdapter(list)
                rvDrinkList.adapter = adapter
            }

            override fun onFailure(call: Call<DrinkResponse>, t: Throwable) {
                Log.d("APIERROR", t.message.toString())
            }
        })
    }

}