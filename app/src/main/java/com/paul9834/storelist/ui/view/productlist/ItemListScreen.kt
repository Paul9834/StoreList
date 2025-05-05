package com.paul9834.storelist.ui.view.productlist


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.paul9834.storelist.R
import com.paul9834.storelist.viewModel.ItemViewModel

@Composable
fun ItemListScreen (viewModel: ItemViewModel = viewModel(), paddingValues: PaddingValues) {

   val products by viewModel.items
   var searchQuery by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {

      SearchBar(
         query = searchQuery,
         onQueryChange = { newQuery -> searchQuery = newQuery },
         placeholderText = stringResource(id = R.string.search_hint)
      )

      if (products.isEmpty()) {
         Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
         }
      } else {
         val filteredProducts by remember(products, searchQuery) {
            derivedStateOf {
               if (searchQuery.isBlank()) {
                  products
               } else {
                  products.filter { product ->
                     product.title?.contains(searchQuery, ignoreCase = true) ?: false
                  }
               }
            }
         }

         if (searchQuery.isNotBlank() && filteredProducts.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().padding(16.dp), contentAlignment = Alignment.Center) {
               Text("No se encontraron productos que coincidan con '$searchQuery'.")
            }
         } else {
            LazyColumn(
               contentPadding = PaddingValues(start = 16.dp, top = 2.dp, end = 16.dp, bottom = 2.dp),
               verticalArrangement = Arrangement.spacedBy(8.dp),
               modifier = Modifier.fillMaxSize()
            ) {
               items(
                  items = filteredProducts,
                  key = { product -> product.id ?: product.hashCode() }
               ) { product ->
                  ItemCard(product)
               }
            }
         }
      }
   }
}

