package com.example.ite_app

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ite_app.databinding.DashboardActivityBinding
import com.example.ite_app.databinding.ProductFragmentBinding

class ProductFragment: Fragment(R.layout.product_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        onInit(view)
    }
    private fun onInit(view: View) {
        val homeAdapter = HomeAdapter(
            listPager = listData,
        )
        val recycleView: RecyclerView = view.findViewById(R.id.secRecycle)

        val gridLayoutManager = GridLayoutManager(view.context, 2)
        recycleView.apply {
            layoutManager = gridLayoutManager
            adapter = homeAdapter
        }
    }
/*    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val homeAdapter = HomeAdapter(
            listPager = listData,
        )
        val firstListAdapter = ListViewAdapter(
            listPager = listData,
        )
        val topPlaceListView = findView<RecyclerView>(R.id.secRecycle)
        binding.apply {
            findViewPager.adapter = homeAdapter
            topPlaceListView.layoutManager =
                LinearLayoutManager(this@ProductFragment, LinearLayoutManager.HORIZONTAL, false)
            topPlaceListView.adapter = secListAdapter
        }


    }*/
}