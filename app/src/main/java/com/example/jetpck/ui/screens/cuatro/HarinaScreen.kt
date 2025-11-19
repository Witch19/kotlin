package com.example.jetpck.ui.screens.cuatro

//package com.example.mipanaderia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HarinaScreen() {
    var panes by remember { mutableStateOf("") }
    var gramosPorPan by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Cálculo de harina necesaria", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = panes,
            onValueChange = { panes = it },
            label = { Text("Cantidad de panes") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = gramosPorPan,
            onValueChange = { gramosPorPan = it },
            label = { Text("Gramos de harina por pan") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val p = panes.toIntOrNull()
                val g = gramosPorPan.toFloatOrNull()

                if (p != null && g != null) {
                    val totalG = p * g
                    val totalKg = totalG / 1000
                    resultado = "Total harina: %.1f g (%.2f kg)".format(totalG, totalKg)
                } else resultado = "Completa ambos campos correctamente."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text("Calcular harina") }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
