package com.example.ite_app.client_side

import com.example.ite_app.model_resp.ProductResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


val retrofitClient = Retrofit.Builder()
    .baseUrl("https://raw.githubusercontent.com/kimsongsao/node-rest-api-with-jwt/refs/heads/main/images/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ProductApiService{
    @GET("products.json")
    suspend fun getListProduct() : List<ProductResponse>
}