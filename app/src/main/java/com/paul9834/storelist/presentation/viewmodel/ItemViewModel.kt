package com.paul9834.storelist.presentation.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paul9834.storelist.data.model.ItemModel
import com.paul9834.storelist.domain.repository.ItemsRepository
import kotlinx.coroutines.launch

class ItemViewModel(
    private val repository: ItemsRepository
) : ViewModel() {

    private val _items = mutableStateOf<List<ItemModel>>(emptyList())
    val items: State<List<ItemModel>> = _items

    init {
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch {
            try {
                _items.value = repository.getProducts()
            } catch (e: Exception) {
                emptyList<ItemModel>().also {
                    e.printStackTrace()
                }
            }
        }
    }
}



