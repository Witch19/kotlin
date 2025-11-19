package com.example.jetpck.ui.navigation

//package com.example.tallerpro.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.tallerpro.ui.screens.*

sealed class AppScreen(val route: String) {
    object Menu : AppScreen("menu")
    object Combustible : AppScreen("combustible")
    object Reparacion : AppScreen("reparacion")
    object Horas : AppScreen("horas")
}

@Composable
fun Navigation() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = AppScreen.Menu.route) {

        composable(AppScreen.Menu.route) { MainMenuScreen(nav) }
        composable(AppScreen.Combustible.route) { ConsumoCombustibleScreen() }
        composable(AppScreen.Reparacion.route) { CostoReparacionScreen() }
        composable(AppScreen.Horas.route) { HorasFacturablesScreen() }
    }
}



