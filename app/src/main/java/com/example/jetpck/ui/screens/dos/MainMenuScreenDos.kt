package com.example.jetpck.ui.screens.dos

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.clinicavetexpress.ui.AppScreen

@Composable
fun MainMenuScreen(nav: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Clínica Vet Express", style = MaterialTheme.typography.headlineMedium)
        Text("Herramientas rápidas para tu clínica veterinaria")

        Spacer(Modifier.height(30.dp))

        Button(onClick = { nav.navigate(AppScreen.Dosis.route) }) {
            Text("Dosis de medicamento")
        }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Plan.route) }) {
            Text("Plan de alimentación")
        }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Costo.route) }) {
            Text("Costo visita + vacunas")
        }
    }
}
