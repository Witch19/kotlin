package com.example.jetpck.ui.screens.tres

//package com.example.tallerpro.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorasFacturablesScreen() {
    var trabajos by remember { mutableStateOf("") }
    var horas by remember { mutableStateOf("") }
    var tarifa by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Horas facturables de la jornada", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = trabajos, onValueChange = { trabajos = it },
            label = { Text("Cantidad de trabajos del día") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = horas, onValueChange = { horas = it },
            label = { Text("Horas totales invertidas") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = tarifa, onValueChange = { tarifa = it },
            label = { Text("Tarifa por hora") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val tr = trabajos.toIntOrNull()
            val h = horas.toFloatOrNull()
            val t = tarifa.toFloatOrNull()

            if (tr != null && h != null && t != null) {
                val ingreso = h * t
                val promedio = ingreso / tr
                resultado = "Horas facturadas: ${h}h\nIngreso total: $%.2f\nPromedio por trabajo: $%.2f"
                    .format(ingreso, promedio)
            } else resultado = "Completa todos los datos correctamente."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular ingresos")
        }

        Text(resultado, modifier = Modifier.padding(top = 25.dp))
    }
}


