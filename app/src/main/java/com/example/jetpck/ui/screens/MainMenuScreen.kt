package com.example.jetpck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpck.ui.navigation.AppScreen

@Composable
fun MainMenuScreen(nav: NavController) {

    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Mi Día Inteligente", style = MaterialTheme.typography.headlineMedium)
        Text("Cálculos rápidos del día")

        Spacer(Modifier.height(30.dp))

        Button(onClick = { nav.navigate(AppScreen.Hidratacion.route) }) {
            Text("Hidratación diaria")
        }

        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Estudio.route) }) {
            Text("Estudio semanal")
        }

        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Transporte.route) }) {
            Text("Transporte mensual")
        }
    }
}

