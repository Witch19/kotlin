package com.example.jetpck.ui.screens.tres

//package com.example.tallerpro.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CostoReparacionScreen() {
    var repuestos by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }
    var tarifa by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Costo total de la reparación", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = repuestos, onValueChange = { repuestos = it },
            label = { Text("Costo de repuestos") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = horas, onValueChange = { horas = it },
            label = { Text("Horas de mano de obra") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = tarifa, onValueChange = { tarifa = it },
            label = { Text("Tarifa por hora") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val r = repuestos.toFloatOrNull()
            val h = horas.toFloatOrNull()
            val t = tarifa.toFloatOrNull()

            if (r != null && h != null && t != null) {
                val manoObra = h * t
                val total = r + manoObra
                resultado =
                    "Repuestos: $r\nMano de obra: $manoObra\nTotal reparación: $%.2f".format(total)
            } else resultado = "Verifica los valores."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular total")
        }

        Text(resultado, modifier = Modifier.padding(top = 25.dp))
    }
}
