package com.example.jetpck.ui.navigation

//package com.example.mipanaderia.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.mipanaderia.ui.screens.*

sealed class AppScreen(val route: String) {
    object Menu : AppScreen("menu")
    object Harina : AppScreen("harina")
    object Costo : AppScreen("costo")
    object Reparto : AppScreen("reparto")
}

@Composable
fun Navigation() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = AppScreen.Menu.route) {
        composable(AppScreen.Menu.route) { MainMenuScreen(nav) }
        composable(AppScreen.Harina.route) { HarinaScreen() }
        composable(AppScreen.Costo.route) { CostoLoteScreen() }
        composable(AppScreen.Reparto.route) { RepartoScreen() }
    }
}




