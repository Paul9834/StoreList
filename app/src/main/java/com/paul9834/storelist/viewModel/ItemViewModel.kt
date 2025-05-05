package com.paul9834.storelist.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paul9834.storelist.data.api.RetrofitInstance
import com.paul9834.storelist.data.model.ItemModel
import kotlinx.coroutines.launch

class ItemViewModel : ViewModel() {

    private val _items = mutableStateOf<List<ItemModel>>(emptyList())
    val items: State<List<ItemModel>> = _items

    init {
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch {
            try {
                _items.value = RetrofitInstance.api.getProducts()
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }
}



