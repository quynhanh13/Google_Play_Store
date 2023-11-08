package com.example.mygoogleplaystoreapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GooglePlayStoreActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.gps_view)

        val allItems = arrayListOf<GPSCategoryModel>()

        repeat(15){
            var cate:GPSCategoryModel = GPSCategoryModel("Category $it", ArrayList<GPSItemModel>())
            repeat(10){
                cate.items.add(GPSItemModel("Item $it", "5"))
            }
            allItems.add(cate)
        }

        val adapter = GPSCategoryAdapter(allItems)
        val recyclerView: RecyclerView = findViewById(R.id.gps_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}