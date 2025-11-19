package com.example.jetpck.ui.screens.dos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DosisMedicamentoScreen() {
    var peso by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Dosis estimada de medicamento", style = MaterialTheme.typography.titleMedium)
        Text("Solo como referencia, no sustituye al veterinario.")

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso de la mascota (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                val p = peso.toFloatOrNull()
                if (p != null && p > 0) {
                    val dosis = p * 0.8f
                    resultado = "Dosis estimada: %.1f ml (referencia)".format(dosis)
                } else {
                    resultado = "Por favor ingresa un peso válido."
                }
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text("Calcular dosis") }

        Text(resultado, modifier = Modifier.padding(top = 25.dp))
    }
}
