package com.paul9834.storelist.ui.view.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.paul9834.storelist.R


@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholderText: String = stringResource(R.string.search_hint_default)
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "Lista de Productos",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 4.dp),
            label = { Text(placeholderText) },
            placeholder = { Text(placeholderText) },
            singleLine = true
        )

    }
}