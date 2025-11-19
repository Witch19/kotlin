package com.example.jetpck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TransporteScreen() {
    var viajes by remember { mutableStateOf("") }
    var costo by remember { mutableStateOf("") }
    var dias by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Transporte mensual", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = viajes, onValueChange = { viajes = it },
            label = { Text("Viajes por día") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = costo, onValueChange = { costo = it },
            label = { Text("Costo por viaje") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = dias, onValueChange = { dias = it },
            label = { Text("Días al mes") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val v = viajes.toIntOrNull()
            val c = costo.toFloatOrNull()
            val d = dias.toIntOrNull()

            if (v != null && c != null && d != null) {
                val total = v * c * d
                resultado = "Gasto mensual estimado: $%.2f".format(total)
            } else resultado = "Completa todos los datos."
        },
            modifier = Modifier.padding(top = 20.dp)
        ) {
            Text("Calcular gasto")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
