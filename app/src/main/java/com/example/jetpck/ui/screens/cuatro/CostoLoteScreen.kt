package com.example.jetpck.ui.screens.cuatro

//package com.example.mipanaderia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CostoLoteScreen() {
    var costoUnidad by remember { mutableStateOf("") }
    var unidades by remember { mutableStateOf("") }
    var margen by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Costo y precio de un lote", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(value = costoUnidad, onValueChange = { costoUnidad = it },
            label = { Text("Costo por unidad (ingredientes)") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = unidades, onValueChange = { unidades = it },
            label = { Text("Cantidad de unidades") }, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = margen, onValueChange = { margen = it },
            label = { Text("Margen de ganancia (%)") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            val c = costoUnidad.toFloatOrNull()
            val u = unidades.toIntOrNull()
            val m = margen.toFloatOrNull()

            if (c != null && u != null && m != null) {
                val costoProduc = c * u
                val precioLote = costoProduc * (1 + m / 100f)
                val precioUnidad = precioLote / u

                resultado = "Costo producción: %.2f\nPrecio sugerido lote: %.2f\nPrecio sugerido unidad: %.2f"
                    .format(costoProduc, precioLote, precioUnidad)
            } else resultado = "Verifica los valores ingresados."
        }, modifier = Modifier.padding(top = 20.dp)) {
            Text("Calcular costos y precios")
        }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
