package com.paul9834.storelist.data.api

import com.paul9834.storelist.data.model.ItemModel
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ItemModel>

}