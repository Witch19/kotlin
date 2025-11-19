package com.example.jetpck.ui.screens.seis

//package com.example.soporte247.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TiempoPromedioScreen() {
    var llamadas by remember { mutableStateOf("") }
    var minutosTotales by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Tiempo promedio por llamada", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = llamadas,
            onValueChange = { llamadas = it },
            label = { Text("Cantidad de llamadas atendidas") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = minutosTotales,
            onValueChange = { minutosTotales = it },
            label = { Text("Minutos totales invertidos") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val l = llamadas.toIntOrNull()
            val m = minutosTotales.toFloatOrNull()

            if (l != null && m != null && l > 0) {
                val promedio = m / l
                val mensaje = when {
                    promedio <= 3 -> "Tiempo rápido"
                    promedio <= 6 -> "Tiempo aceptable"
                    else -> "Tiempo demasiado alto"
                }
                resultado = "Promedio: %.2f minutos por llamada\n$mensaje".format(promedio)
            } else resultado = "Completa correctamente los datos."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular promedio")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
