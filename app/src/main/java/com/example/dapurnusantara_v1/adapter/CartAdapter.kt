package com.example.dapurnusantara_v1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.model.Cart
import kotlinx.android.synthetic.main.cart_item.view.*

class CartAdapter(private val list: ArrayList<Cart>):RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    inner class CartViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(cart: Cart){
            with(itemView){
                tvCartItemTitle.text = "${cart.item}"
                tvCartItemPrice.text = "${cart.price}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}