package com.example.jetpck.ui.navigation

//package com.example.soporte247.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.soporte247.ui.screens.*

sealed class AppScreen(val route: String) {
    object Menu : AppScreen("menu")
    object Promedio : AppScreen("promedio")
    object Productividad : AppScreen("productividad")
    object Costo : AppScreen("costo")
}

@Composable
fun Navigation() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = AppScreen.Menu.route) {

        composable(AppScreen.Menu.route) { MainMenuScreen(nav) }
        composable(AppScreen.Promedio.route) { TiempoPromedioScreen() }
        composable(AppScreen.Productividad.route) { ProductividadScreen() }
        composable(AppScreen.Costo.route) { CostoLlamadaScreen() }
    }
}






