package com.example.mygoogleplaystoreapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mygoogleplaystoreapplication.GPSItemModel

class GPSItemAdapter(val items: ArrayList<GPSItemModel>): RecyclerView.Adapter<GPSItemAdapter.GPSItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GPSItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.gps_item_layout, parent, false)
        return GPSItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GPSItemViewHolder, position: Int) {
        holder.itemName.text = items[position].name
        holder.itemRating.text = items[position].rating
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class GPSItemViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        val itemName: TextView = itemView.findViewById(R.id.item_name)
        val itemRating: TextView = itemView.findViewById(R.id.item_rating)
    }
}