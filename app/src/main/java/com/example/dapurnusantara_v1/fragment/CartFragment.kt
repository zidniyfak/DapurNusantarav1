package com.example.dapurnusantara_v1.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.adapter.CartAdapter
import com.example.dapurnusantara_v1.adapter.MakananAdapter
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.model.Cart
import com.example.dapurnusantara_v1.model.CartResponse
import com.example.dapurnusantara_v1.model.Food
import com.example.dapurnusantara_v1.model.FoodResponse
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_menu_makanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var list = ArrayList<Cart>()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        recyclerView = view.findViewById(R.id.rvCart)

        showFood()
        return view
    }

    private fun showFood() {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        RClient.instance.getCart().enqueue(object : Callback<CartResponse> {
            override fun onResponse(call: Call<CartResponse>, response: Response<CartResponse>) {
                val listResponse = response.body()?.data

                listResponse?.let { list.addAll(it) }
                val adapter = CartAdapter(list)

                rvCart.adapter = adapter
            }

            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                Log.d("APIERROR", t.message.toString())
            }
        })
    }

    companion object {
        fun newInstance(): CartFragment {
            return CartFragment()
        }

    }
}