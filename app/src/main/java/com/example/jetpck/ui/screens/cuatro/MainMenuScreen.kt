package com.example.jetpck.ui.screens.cuatro

//package com.example.mipanaderia.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mipanaderia.ui.AppScreen

@Composable
fun MainMenuScreen(nav: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mi Panadería", style = MaterialTheme.typography.headlineMedium)
        Text("Cálculos rápidos de producción")

        Spacer(Modifier.height(30.dp))

        Button(onClick = { nav.navigate(AppScreen.Harina.route) }) { Text("Harina necesaria") }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Costo.route) }) { Text("Costo de un lote") }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Reparto.route) }) { Text("Reparto matutino") }
    }
}
