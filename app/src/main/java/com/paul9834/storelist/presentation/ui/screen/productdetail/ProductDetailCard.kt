package com.paul9834.storelist.presentation.ui.screen.productdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.paul9834.storelist.data.model.ItemModel


@Composable
fun ProductDetailCard(item: ItemModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                AsyncImage(
                    model = item.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(180.dp)
                        .padding(end = 8.dp, bottom = 15.dp, top = 15.dp)
                        .align(Alignment.CenterHorizontally)
                    ,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Category: ${item.category}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black
                )
                Text(
                    text = "Rating: ${item.rating?.rate}",
                    modifier = Modifier.padding(vertical = 8.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.Black
                )
                Text(
                    text = "${item.description}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                )
                Text(
                    text = "Price: ${item.price}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.Black,
                    modifier = Modifier.padding(vertical = 8.dp))
            }
        }
    }
}