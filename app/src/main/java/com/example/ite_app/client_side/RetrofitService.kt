package com.example.ite_app.client_side

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofitClient = Retrofit.Builder()
    .baseUrl("https://raw.githubusercontent.com")
    .addConverterFactory(GsonConverterFactory.create())
    .build()