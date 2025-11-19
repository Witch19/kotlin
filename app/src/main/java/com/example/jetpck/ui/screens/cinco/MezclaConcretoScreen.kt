package com.example.jetpck.ui.screens.cinco

//package com.example.obrafacil.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MezclaConcretoScreen() {
    var metrosCubicos by remember { mutableStateOf("") }
    var sacosPorMetro by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {
        Text("Sacos de cemento para la mezcla", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = metrosCubicos,
            onValueChange = { metrosCubicos = it },
            label = { Text("Metros cúbicos de concreto") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = sacosPorMetro,
            onValueChange = { sacosPorMetro = it },
            label = { Text("Sacos por metro cúbico") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val mc = metrosCubicos.toFloatOrNull()
                val spm = sacosPorMetro.toFloatOrNull()

                if (mc != null && spm != null) {
                    val total = mc * spm
                    val totalExtra = total * 1.10f
                    resultado =
                        "Necesitas aproximadamente %.1f sacos.\nIncluye reserva del 10%%: %.1f sacos."
                            .format(total, totalExtra)
                } else resultado = "Completa los datos correctamente."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text("Calcular sacos") }

        Text(resultado, Modifier.padding(top = 25.dp))
    }
}
