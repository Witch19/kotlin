package com.example.jetpck.ui.screens.seis

//package com.example.soporte247.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductividadScreen() {
    var tickets by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Productividad diaria del agente", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = tickets, onValueChange = { tickets = it },
            label = { Text("Tickets/casos resueltos") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = horas, onValueChange = { horas = it },
            label = { Text("Horas trabajadas") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val t = tickets.toIntOrNull()
            val h = horas.toFloatOrNull()

            if (t != null && h != null && h > 0) {
                val tph = t / h
                val nivel = when {
                    tph < 3 -> "Productividad baja"
                    tph < 6 -> "Productividad media"
                    else -> "Productividad alta"
                }
                resultado = "Tickets por hora: %.2f\n$nivel".format(tph)
            } else resultado = "Verifica los valores ingresados."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular productividad")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
