package com.example.jetpck.ui.screens.dos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CostoVisitaVacunasScreen() {
    var consulta by remember { mutableStateOf("") }
    var costoVacuna by remember { mutableStateOf("") }
    var cantidad by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Costo de visita y vacunas", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = consulta,
            onValueChange = { consulta = it },
            label = { Text("Costo base de consulta") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = costoVacuna,
            onValueChange = { costoVacuna = it },
            label = { Text("Costo por vacuna") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Cantidad de vacunas") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = {
            val c = consulta.toFloatOrNull()
            val v = costoVacuna.toFloatOrNull()
            val n = cantidad.toIntOrNull()

            if (c != null && v != null && n != null) {
                val total = c + (v * n)
                resultado = "Total estimado: $%.2f\n(Consulta: $c / Vacunas: $v x $n)".format(total)
            } else resultado = "Revisa los valores ingresados."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular total")
        }

        Text(resultado, modifier = Modifier.padding(top = 25.dp))
    }
}
