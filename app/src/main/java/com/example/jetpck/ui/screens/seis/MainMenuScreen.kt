package com.example.jetpck.ui.screens.seis

//package com.example.soporte247.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpck.ui.AppScreen

@Composable
fun MainMenuScreen(nav: NavController) {

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Soporte 24/7", style = MaterialTheme.typography.headlineMedium)
        Text("Indicadores rápidos de desempeño")

        Spacer(Modifier.height(30.dp))

        Button(onClick = { nav.navigate(AppScreen.Promedio.route) }) {
            Text("Tiempo promedio de atención")
        }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Productividad.route) }) {
            Text("Productividad del agente")
        }
        Spacer(Modifier.height(12.dp))

        Button(onClick = { nav.navigate(AppScreen.Costo.route) }) {
            Text("Costo por llamada")
        }
    }
}
