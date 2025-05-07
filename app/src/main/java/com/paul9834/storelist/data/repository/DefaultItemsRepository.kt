package com.paul9834.storelist.data.repository

import com.paul9834.storelist.data.api.RetrofitInstance
import com.paul9834.storelist.data.model.ItemModel
import com.paul9834.storelist.domain.repository.ItemsRepository

class DefaultItemsRepository : ItemsRepository {

    override suspend fun getProducts(): List<ItemModel> {
        return RetrofitInstance.api.getProducts()
    }

}