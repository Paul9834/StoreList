package com.paul9834.storelist.ui.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit, // Función para notificar cambios hacia arriba
    modifier: Modifier = Modifier,     // Modificador opcional
    placeholderText: String = "Buscar..." // Placeholder por defecto
) {
    OutlinedTextField(
        value = query, // Muestra el estado actual que viene del padre
        onValueChange = onQueryChange, // Notifica al padre cuando el valor cambia
        modifier = modifier // Aplica modificadores pasados desde el padre
            .fillMaxWidth() // Ocupa el ancho disponible por defecto
            .padding(horizontal = 16.dp, vertical = 16.dp), // Padding estándar
        label = { Text(placeholderText) },
        placeholder = { Text(placeholderText) },
        singleLine = true // Usualmente queremos una sola línea para búsquedas
    )
}