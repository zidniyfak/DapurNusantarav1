package com.example.dapurnusantara_v1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.model.Drink
import kotlinx.android.synthetic.main.drink_item.view.*
import kotlinx.android.synthetic.main.food_item.view.*

class DrinkAdapter(private val list: ArrayList<Drink>): RecyclerView.Adapter<DrinkAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(drink: Drink){
            with(itemView){
                tvDrinkName.text = "${drink.nama_minuman}"
                tvPriceDrink.text = "${drink.harga}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.drink_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size


//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): DrinkAdapter.UserViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)
//
//        return UserViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MakananAdapter.UserViewHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    override fun getItemCount(): Int = list.size


}