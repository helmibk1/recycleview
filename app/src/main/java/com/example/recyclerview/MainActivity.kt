package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycleView)
        recyclerView.adapter = Adapter(getList(),::onClickItem)
    }

    private fun getList(): List<Product> {
        val list = ArrayList<Product>()

        list.add(Product("HeadPhone",
            "Headphones are a hardware device that can be plugged into a computer",
            R.drawable.img1))
        list.add(Product("SmartWatch",
            "Headphones are a hardware device that can be plugged into a computer",
            R.drawable.img2))
        list.add(Product("Mouse",
            "Headphones are a hardware device that can be plugged into a computer",
            R.drawable.img3))
        list.add(Product("Speaker",
            "Headphones are a hardware device that can be plugged into a computer",
            R.drawable.img4))

        return list
    }
    private fun onClickItem(product:Product){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }
}