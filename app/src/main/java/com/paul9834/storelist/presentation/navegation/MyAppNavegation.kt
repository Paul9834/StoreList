package com.paul9834.storelist.presentation.navegation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.paul9834.storelist.data.model.ItemModel
import com.paul9834.storelist.presentation.ui.screen.productdetail.ProductDetailScreen
import com.paul9834.storelist.presentation.ui.screen.productlist.ItemListScreen



@Composable
fun MyAppNavegation(paddingValues: PaddingValues) {

    val navController = rememberNavController()

    // Pantalla de lista

    NavHost(
        navController = navController,
        startDestination = NavRoutes.List,
    ) {
        composable(NavRoutes.List) {
            ItemListScreen(
                navController = navController,
                paddingValues = paddingValues
            )
        }

     // Pantalla de item detalle

        composable(route = NavRoutes.Detail) { backStackEntry ->

            val item = navController
                .previousBackStackEntry
                ?.savedStateHandle
                ?.get<ItemModel>("selectedItem")

            Log.e("ItemViewModel", "ItemViewModel: $item")

            item?.let {
                ProductDetailScreen(
                    itemModel = it
                )
            }

        }
    }

}