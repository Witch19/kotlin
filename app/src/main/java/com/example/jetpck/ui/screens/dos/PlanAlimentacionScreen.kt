package com.example.jetpck.ui.screens.dos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PlanAlimentacionScreen() {
    var peso by remember { mutableStateOf("") }
    var actividad by remember { mutableStateOf("Media") }
    var resultado by remember { mutableStateOf("") }

    val niveles = listOf("Baja", "Media", "Alta")

    Column(Modifier.fillMaxSize().padding(20.dp)) {

        Text("Plan de alimentación para tu mascota", style = MaterialTheme.typography.titleMedium)

        OutlinedTextField(
            value = peso,
            onValueChange = { peso = it },
            label = { Text("Peso (kg)") },
            modifier = Modifier.fillMaxWidth()
        )

        Text("Nivel de actividad:")
        niveles.forEach {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = actividad == it,
                    onClick = { actividad = it }
                )
                Text(it)
            }
        }

        Button(
            onClick = {
                val p = peso.toFloatOrNull()
                if (p != null && p > 0) {
                    val factor = when (actividad) {
                        "Baja" -> 35
                        "Media" -> 45
                        else -> 60
                    }
                    val gramos = p * factor
                    resultado =
                        "Ración diaria aprox.: %.0f g\nSe recomienda dividir en 2 o 3 comidas al día."
                            .format(gramos)
                } else resultado = "Completa los datos correctamente."
            },
            modifier = Modifier.padding(top = 20.dp)
        ) { Text("Calcular ración") }

        Text(resultado, modifier = Modifier.padding(top = 25.dp))
    }
}
