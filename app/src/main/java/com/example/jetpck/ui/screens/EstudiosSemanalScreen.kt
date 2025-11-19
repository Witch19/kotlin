package com.example.jetpck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EstudioSemanalScreen() {
    var minutos by remember { mutableStateOf("") }
    var dias by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Estudio semanal", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = dias,
            onValueChange = { dias = it },
            label = { Text("Días de estudio (5-7)") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = minutos,
            onValueChange = { minutos = it },
            label = { Text("Minutos por día") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val d = dias.toIntOrNull()
                val m = minutos.toIntOrNull()

                if (d != null && m != null && d in 5..7) {
                    var total = 0
                    for (i in 1..d) total += m
                    val promedio = total / d
                    resultado =
                        "Total min: $total\nPromedio diario: $promedio min\n¡Buen trabajo!"
                } else resultado = "Datos inválidos."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Calcular resumen")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
