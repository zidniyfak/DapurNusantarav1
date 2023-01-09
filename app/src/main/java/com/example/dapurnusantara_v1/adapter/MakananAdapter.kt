package com.example.dapurnusantara_v1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.model.Food
import kotlinx.android.synthetic.main.food_item.view.*

class MakananAdapter(private val list: ArrayList<Food>):RecyclerView.Adapter<MakananAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(food: Food){
            with(itemView){
                val text = "nama_makanan :${food.nama_makanan}\n"
                tvTextNama.text = text

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}





