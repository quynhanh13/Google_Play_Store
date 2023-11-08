package com.example.mygoogleplaystoreapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecycledViewPool
import com.example.mygoogleplaystoreapplication.GPSCategoryModel
import com.example.mygoogleplaystoreapplication.GPSItemAdapter
import com.example.mygoogleplaystoreapplication.R

class GPSCategoryAdapter(val cates: ArrayList<GPSCategoryModel>):RecyclerView.Adapter<GPSCategoryAdapter.GPSCategoryViewHolder>() {
    private val viewPool = RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GPSCategoryViewHolder {
        val cateView = LayoutInflater.from(parent.context)
            .inflate(R.layout.gps_cate_layout, parent, false)
        return GPSCategoryViewHolder(cateView)
    }

    override fun onBindViewHolder(holder: GPSCategoryViewHolder, position: Int) {
        holder.cateName.text = cates[position].cateName;

        val layoutManager = LinearLayoutManager(holder.cateItems.context, LinearLayoutManager.HORIZONTAL, false)
        //layoutManager.initialPrefetchItemCount = cates[position].items.size
        val adapter = GPSItemAdapter(cates[position].items)

        holder.cateItems.layoutManager = layoutManager
        holder.cateItems.adapter = adapter
        //holder.cateItems.setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int {
        return cates.size
    }

    class GPSCategoryViewHolder(val cateView: View): RecyclerView.ViewHolder(cateView){
        val cateName: TextView = cateView.findViewById(R.id.cate_name)
        val cateItems: RecyclerView = cateView.findViewById(R.id.gps_items_recycler_view)
    }
}