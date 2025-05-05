package com.paul9834.storelist.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.paul9834.storelist.data.model.ItemModel
import com.paul9834.storelist.ui.theme.PurpleGrey80
import com.paul9834.storelist.viewModel.ItemViewModel

@Composable
fun ItemListScreen (viewModel: ItemViewModel = ItemViewModel(), paddingValues: PaddingValues) {

   val products by viewModel.items

   if (products.isEmpty()) {
      Box(
         modifier = Modifier.fillMaxSize(),
         contentAlignment = Alignment.Center
      ) {
         CircularProgressIndicator()
      }
   } else {
      LazyColumn(
         contentPadding = PaddingValues(16.dp),
         verticalArrangement = Arrangement.spacedBy(8.dp),
         modifier = Modifier.padding(paddingValues)
      ) {
         items(products) {
            ItemCard(it)
         }
      }
   }
}

@Composable
fun ItemCard(item: ItemModel) {
   Card(
      modifier = Modifier.fillMaxSize(),
      colors = CardDefaults.cardColors(PurpleGrey80)
   ) {

      Column(
         modifier = Modifier.padding(16.dp)
      ) {
         Text(
            text = "Product Name: ${item.title}",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Blue
         )
         AsyncImage(
            model = item.image,
            contentDescription = null,
            modifier = Modifier
               .size(100.dp)
               .padding(end = 8.dp, bottom = 8.dp, top = 8.dp),
            contentScale = ContentScale.Crop
         )
         Text(
            text = "Category: ${item.category}",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
         )
         Text(
            text = "Description: ${item.description}",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
         )
      }
   }


}