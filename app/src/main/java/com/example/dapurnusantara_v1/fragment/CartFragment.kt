package com.example.dapurnusantara_v1.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.activity.LoginActivity
import com.example.dapurnusantara_v1.adapter.CartAdapter
import com.example.dapurnusantara_v1.adapter.MakananAdapter
import com.example.dapurnusantara_v1.api.RClient
import com.example.dapurnusantara_v1.model.Cart
import com.example.dapurnusantara_v1.model.CartResponse
import com.example.dapurnusantara_v1.model.Food
import com.example.dapurnusantara_v1.model.FoodResponse
import com.example.dapurnusantara_v1.shared_preferences.PrefManager
import kotlinx.android.synthetic.main.fragment_cart.*
import kotlinx.android.synthetic.main.fragment_menu_makanan.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var list = ArrayList<Cart>()
    private lateinit var prefManager: PrefManager

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cart, container, false)
        recyclerView = view.findViewById(R.id.rvCart)
        prefManager = PrefManager(requireContext())
        val token = prefManager.getToken()

        if (token == null || token == ""){
            Toast.makeText(activity,"Silahkan login dahulu",Toast.LENGTH_LONG).show()
//            startActivity(Intent(activity,LoginActivity::class.java))
        }else{
//            Toast.makeText(context,token,Toast.LENGTH_LONG).show()
            showCart(token)
        }
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        prefManager = PrefManager(requireContext())
//    }

    private fun showCart(token:String) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val token_auth = "Bearer ${token}"
        RClient.instance.getCart(token_auth).enqueue(object : Callback<CartResponse> {
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