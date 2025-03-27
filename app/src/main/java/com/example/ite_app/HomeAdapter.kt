package com.example.ite_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeAdapter(
    private val listPager: List<HomeModel>,
) :
    RecyclerView.Adapter<HomeAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.pager_fragment, parent, false)
        return PagerViewHolder(view)
    }

    override fun getItemCount(): Int = listPager.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        val item = listPager[position]
        holder.imageView.setImageResource(item.imgRes)
    }
}