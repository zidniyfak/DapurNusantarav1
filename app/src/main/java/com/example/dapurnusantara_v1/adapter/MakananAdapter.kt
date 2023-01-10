package com.example.dapurnusantara_v1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.activity.FoodDetailActivity
import com.example.dapurnusantara_v1.databinding.ActivityFoodDetailBinding
import com.example.dapurnusantara_v1.model.Food
import kotlinx.android.synthetic.main.food_item.view.*

class MakananAdapter(private val list: ArrayList<Food>):RecyclerView.Adapter<MakananAdapter.UserViewHolder>() {
    inner class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val cardView: CardView = itemView.findViewById(R.id.cvFoodItem)
        fun bind(food: Food){
            with(itemView){
                val text = "${food.nama_makanan}\n"
                tvFoodName.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.food_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
        val food = list[position]
        holder.cardView.setOnClickListener{
            val intent = Intent(holder.cardView.context,FoodDetailActivity::class.java)
            intent.putExtra("FoodName", food.nama_makanan)
            holder.cardView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = list.size
}





