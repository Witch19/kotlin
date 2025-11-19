package com.example.jetpck.ui.screens.seis

//package com.example.soporte247.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CostoLlamadaScreen() {
    var costoTurno by remember { mutableStateOf("") }
    var llamadas by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Costo promedio por llamada", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = costoTurno,
            onValueChange = { costoTurno = it },
            label = { Text("Costo total del turno") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = llamadas,
            onValueChange = { llamadas = it },
            label = { Text("Total de llamadas del turno") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val c = costoTurno.toFloatOrNull()
            val l = llamadas.toIntOrNull()

            if (c != null && l != null && l > 0) {
                val costoPorLlamada = c / l
                resultado = "Costo aproximado por llamada: $%.2f".format(costoPorLlamada)
            } else resultado = "Corrige los valores ingresados."
        },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Calcular costo")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
