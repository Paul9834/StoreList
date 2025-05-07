package com.paul9834.storelist.presentation.ui.screen.productdetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paul9834.storelist.data.model.ItemModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(itemModel: ItemModel) {

    Scaffold (
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .padding(horizontal = 16.dp),
                title = { Text(itemModel.title.orEmpty()) }
            )
        }
    ) {
       innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            item {
            ProductDetailCard(itemModel)
            }
        }
    }
}



