package com.example.jetpck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HidratacionScreen() {
    var peso by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Hidratación diaria", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Ingresa tu peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val p = peso.toFloatOrNull()
                if (p != null) {
                    val litros = p * 0.033
                    resultado = "Debes beber %.2f litros de agua al día".format(litros)
                } else resultado = "Ingresa un valor válido."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Calcular")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
