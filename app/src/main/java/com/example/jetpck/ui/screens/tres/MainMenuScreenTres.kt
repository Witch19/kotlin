package com.example.jetpck.ui.screens.tres

//package com.example.tallerpro.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tallerpro.ui.AppScreen

@Composable
fun MainMenuScreen(nav: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Taller Pro", style = MaterialTheme.typography.headlineMedium)
        Text("Cálculos rápidos para tu taller mecánico")

        Spacer(Modifier.height(30.dp))

        Button(onClick = { nav.navigate(AppScreen.Combustible.route) }) {
            Text("Consumo de combustible")
        }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Reparacion.route) }) {
            Text("Costo de reparación")
        }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Horas.route) }) {
            Text("Horas facturables del día")
        }
    }
}
