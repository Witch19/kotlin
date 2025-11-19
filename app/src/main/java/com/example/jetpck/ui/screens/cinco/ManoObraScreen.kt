package com.example.jetpck.ui.screens.cinco

//package com.example.obrafacil.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ManoObraScreen() {
    var trabajadores by remember { mutableStateOf("") }
    var horasDia by remember { mutableStateOf("") }
    var dias by remember { mutableStateOf("") }
    var tarifa by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Costo total de mano de obra", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = trabajadores, onValueChange = { trabajadores = it },
            label = { Text("Número de trabajadores") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = horasDia, onValueChange = { horasDia = it },
            label = { Text("Horas por día") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = dias, onValueChange = { dias = it },
            label = { Text("Días de trabajo") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = tarifa, onValueChange = { tarifa = it },
            label = { Text("Tarifa por hora") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val t = trabajadores.toIntOrNull()
            val h = horasDia.toFloatOrNull()
            val d = dias.toIntOrNull()
            val tf = tarifa.toFloatOrNull()

            if (t != null && h != null && d != null && tf != null) {
                val horasTotales = t * h * d
                val costo = horasTotales * tf
                resultado = "Horas totales: $horasTotales h\nCosto estimado: $%.2f\n(Solo mano de obra)".format(costo)
            } else resultado = "Completa todos los datos."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular costo")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}

