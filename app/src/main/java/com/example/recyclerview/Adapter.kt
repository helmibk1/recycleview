package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val products: List<Product>,val onClick : (p:Product) -> Unit):
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView
        val description: TextView
        val image: ImageView
        val constrainLayout: ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.name)
            description = view.findViewById(R.id.description)
            image = view.findViewById(R.id.imageView)
            constrainLayout = view.findViewById(R.id.constraint_layout)
        }
        fun bind(product: Product,adapter: Adapter ) {

            name.text = product.productName
            description.text = product.productDescription
            image.setImageResource(product.image)
            constrainLayout.setOnClickListener{
                adapter.onClick(product)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_product_view, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(products[position],this)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = products.size

}