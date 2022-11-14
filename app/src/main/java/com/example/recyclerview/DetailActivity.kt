package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var name: TextView
    private lateinit var description: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val product = intent.getSerializableExtra("product") as Product

        imageView = findViewById(R.id.image)
        name = findViewById(R.id.detail_title)
        description = findViewById(R.id.detail_description)

        imageView.setImageResource(product.image)
        name.text = product.productName
        description.text = product.productDescription
    }
}