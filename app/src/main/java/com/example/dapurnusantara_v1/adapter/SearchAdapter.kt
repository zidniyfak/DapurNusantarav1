package com.example.dapurnusantara_v1.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.R
import com.example.dapurnusantara_v1.activity.FoodDetailActivity
import com.example.dapurnusantara_v1.databinding.SearchItemBinding
import com.example.dapurnusantara_v1.model.Food
import kotlinx.android.synthetic.main.food_item.view.*
import kotlinx.android.synthetic.main.search_item.view.*

class SearchAdapter(private val listSearch:ArrayList<Food>):RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){
    inner class SearchViewHolder(item:SearchItemBinding):RecyclerView.ViewHolder(item.root){
        private val binding = item
        val cardView: CardView = itemView.findViewById(R.id.cvSearchItem)
        fun bind(food: Food){
            with(binding){
                tvSearchItem.text = "${food.name}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(SearchItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(listSearch[position])
        val item = listSearch[position]
        holder.cardView.setOnClickListener{
            val intent = Intent(holder.cardView.context, FoodDetailActivity::class.java)
            intent.putExtra("FoodName", item.name)
            holder.cardView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listSearch.size
}