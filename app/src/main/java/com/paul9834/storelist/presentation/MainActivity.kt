package com.paul9834.storelist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.paul9834.storelist.presentation.ui.theme.StoreListTheme
import com.paul9834.storelist.presentation.navegation.MyAppNavegation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StoreListTheme {
                Scaffold(
                    modifier = Modifier.Companion.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ) { innerPadding: PaddingValues ->
                    MyAppNavegation(paddingValues = innerPadding)
                }
            }
        }
    }
}