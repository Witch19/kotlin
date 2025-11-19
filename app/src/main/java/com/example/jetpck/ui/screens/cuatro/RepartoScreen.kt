package com.example.jetpck.ui.screens.cuatro

//package com.example.mipanaderia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RepartoScreen() {
    var panes by remember { mutableStateOf("") }
    var puntos by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Reparto de panes en la mañana", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = panes, onValueChange = { panes = it },
            label = { Text("Total de panes") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = puntos, onValueChange = { puntos = it },
            label = { Text("Puntos de venta") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val p = panes.toIntOrNull()
            val pv = puntos.toIntOrNull()

            if (p != null && pv != null && pv > 0) {
                val promedio = p / pv
                val sobra = p % pv
                val mensaje = if (sobra == 0)
                    "Distribución equilibrada."
                else "Sobran $sobra panes."

                resultado = "Promedio: $promedio panes por punto.\n$mensaje"
            } else resultado = "Completa correctamente los campos."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular reparto")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
