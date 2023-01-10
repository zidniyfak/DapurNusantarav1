package com.example.dapurnusantara_v1.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dapurnusantara_v1.model.History

class HistoryAdapter(private val list:ArrayList<History>):RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    inner class HistoryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(history: History){
            with(itemView){
                val text = "${history.status}"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}