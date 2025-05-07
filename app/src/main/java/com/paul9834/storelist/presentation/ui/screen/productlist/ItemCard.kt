package com.paul9834.storelist.presentation.ui.screen.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.paul9834.storelist.data.model.ItemModel
import com.paul9834.storelist.presentation.navegation.NavRoutes

@Composable
fun ItemCard(navController: NavController, item: ItemModel) {
    ElevatedCard(
        modifier = Modifier.fillMaxSize(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        onClick = {

            navController.currentBackStackEntry
                ?.savedStateHandle
                ?.set("selectedItem", item)

            navController.navigate(NavRoutes.Detail)

        },
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "${item.title}",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium
                ))
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