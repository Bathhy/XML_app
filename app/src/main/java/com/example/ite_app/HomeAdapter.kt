package com.example.ite_app

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ite_app.model_resp.ProductResponse
import com.squareup.picasso.Picasso

class HomeAdapter(
    private var listPager: List<ProductResponse>,
    private val onItemClick: (ProductResponse) -> Unit
) :
    RecyclerView.Adapter<HomeAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img)
        val priceLabel: TextView = view.findViewById(R.id.price_id)
        val rateValue: TextView = view.findViewById(R.id.ratingValueId)
        val productName: TextView = view.findViewById(R.id.product_name_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pager_fragment, parent, false)
        return PagerViewHolder(view)
    }

    override fun getItemCount(): Int = listPager.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val item = listPager[position]
        holder.priceLabel.text = "$${item.price}"
        holder.rateValue.text = item.rating.toString()
        holder.productName.text = item.name

        Picasso.get()
            .load(item.image) // image URL
            .placeholder(R.drawable.cadt)   // optional placeholder
            .error(R.drawable.cadt)               // optional error image
            .into(holder.imageView)
        holder.itemView.setOnClickListener {
            onItemClick(item) // Trigger click listener
        }
    }

    fun updateData(newList: List<ProductResponse>) {
        listPager = newList
        notifyDataSetChanged()
    }
}