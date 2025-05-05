package com.paul9834.storelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.paul9834.storelist.ui.theme.StoreListTheme
import com.paul9834.storelist.ui.view.productlist.ItemListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoreListTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = Color.LightGray

                ) {
                    ItemListScreen(
                        paddingValues = it
                    )
                }
            }
        }
    }
}
