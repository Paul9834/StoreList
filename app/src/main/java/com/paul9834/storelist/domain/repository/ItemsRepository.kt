package com.paul9834.storelist.domain.repository

import com.paul9834.storelist.data.model.ItemModel

interface ItemsRepository {
    suspend fun getProducts(): List<ItemModel>
}