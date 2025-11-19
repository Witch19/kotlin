package com.example.jetpck.ui.screens.tres

//package com.example.tallerpro.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ConsumoCombustibleScreen() {
    var km by remember { mutableStateOf("") }
    var litros by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Consumo de combustible del vehículo", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = km,
            onValueChange = { km = it },
            label = { Text("Kilómetros recorridos") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = litros,
            onValueChange = { litros = it },
            label = { Text("Litros consumidos") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val k = km.toFloatOrNull()
                val l = litros.toFloatOrNull()

                if (k != null && l != null && k > 0 && l > 0) {
                    val consumo = k / l
                    val estado = when {
                        consumo >= 15 -> "Consumo eficiente"
                        consumo >= 10 -> "Consumo moderado"
                        else -> "Consumo alto"
                    }
                    resultado = "Consumo aproximado: %.2f km/L\n$estado".format(consumo)
                } else resultado = "Corrige los valores ingresados."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text("Calcular consumo") }

        Text(resultado, modifier = Modifier.padding(top = 25.dp))
    }
}
