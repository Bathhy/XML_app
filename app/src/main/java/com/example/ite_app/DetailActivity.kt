package com.example.ite_app

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ite_app.model_resp.ProductResponse
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        val product = intent.getSerializableExtra(keyParam) as? ProductResponse
        val navBack = findViewById<ImageView>(R.id.backIcon)
        navBack.setOnClickListener {
            finish()
        }
        product?.let {
            // Replace these IDs with your actual view IDs
            findViewById<TextView>(R.id.titleText).text = it.name
            findViewById<TextView>(R.id.price_id).text = "$${it.price}"
            findViewById<TextView>(R.id.ratingValueId).text = it.rating.toString()
            findViewById<TextView>(R.id.product_label_idd).text = it.name
            findViewById<TextView>(R.id.desc_id).text = it.description
            val imageView = findViewById<ImageView>(R.id.productImage)

            Picasso.get()
                .load(product.image) // image URL
                .placeholder(R.drawable.cadt)   // optional placeholder
                .error(R.drawable.cadt)               // optional error image
                .into(imageView)
        }
    }
}