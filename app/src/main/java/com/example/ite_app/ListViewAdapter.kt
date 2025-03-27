package com.example.ite_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListViewAdapter(
    private val listPager: List<HomeModel>,
) :
    RecyclerView.Adapter<ListViewAdapter.ListViewHolder>() {
    inner class ListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.img)
        val textView: TextView = view.findViewById(R.id.textLabel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.list_card_activity, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listPager[position]
        holder.imageView.setImageResource(item.imgRes)
        holder.textView.text = item.name
    }


    override fun getItemCount(): Int = listPager.size


}