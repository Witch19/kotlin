package com.example.jetpck.ui.screens.cinco

//package com.example.obrafacil.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LadrillosScreen() {
    var metrosCuadrados by remember { mutableStateOf("") }
    var ladrillosPorMetro by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Cálculo de ladrillos necesarios", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = metrosCuadrados,
            onValueChange = { metrosCuadrados = it },
            label = { Text("Metros cuadrados de pared") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = ladrillosPorMetro,
            onValueChange = { ladrillosPorMetro = it },
            label = { Text("Ladrillos por metro cuadrado") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val mc = metrosCuadrados.toFloatOrNull()
                val lpm = ladrillosPorMetro.toFloatOrNull()

                if (mc != null && lpm != null) {
                    val total = mc * lpm
                    resultado =
                        "Necesitas aproximadamente %.0f ladrillos.\nConsidera un extra por roturas."
                            .format(total)
                } else resultado = "Ingresa valores válidos."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text("Calcular ladrillos") }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
