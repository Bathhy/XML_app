package com.example.ite_app.model_resp

import java.io.Serializable

data class ProductResponse (
    val id: String? = null,
    val sku: String? = null,
    val name: String? = null,
    val description: String? = null,
    val price: Long? = null,
    val image: String? = null,
    val rating: Double? = null
):Serializable
