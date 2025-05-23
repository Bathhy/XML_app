package com.example.ite_app

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ite_app.client_side.ProductApiService
import com.example.ite_app.client_side.retrofitClient
import kotlinx.coroutines.launch

class ProductFragment: Fragment(R.layout.product_fragment) {
    private lateinit var homeAdapter: HomeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInit(view)
        getListProduct()
    }

    private fun onInit(view: View) {
        homeAdapter = HomeAdapter(emptyList())
        val recycleView: RecyclerView = view.findViewById(R.id.secRecycle)

        val gridLayoutManager = GridLayoutManager(view.context, 2)
        recycleView.apply {
            layoutManager = gridLayoutManager
            adapter = homeAdapter
        }
    }

    private fun getListProduct() {
        val res = retrofitClient.create(ProductApiService::class.java)
        lifecycleScope.launch {
            try {
                val data = res.getListProduct()
                Log.d("sucLog", "getListProduct: ${data.size}")
                homeAdapter.updateData(data)
            } catch (e: Exception) {
                Log.d("errorLog", "getListProduct: ${e.message}")
                context?.let {
                    Toast.makeText(it, "Error fetching products: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
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