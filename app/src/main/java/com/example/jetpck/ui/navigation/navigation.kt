package com.example.jetpck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpck.ui.screens.*
import com.example.jetpck.ui.screens.dos.MainMenuScreen

sealed class AppScreen(val route: String) {
    object Menu : AppScreen("menu")
    object Hidratacion : AppScreen("hidratacion")
    object Estudio : AppScreen("estudio")
    object Transporte : AppScreen("transporte")
}

@Composable
fun AppNavigation() {
    val nav = rememberNavController()

    NavHost(
        navController = nav,
        startDestination = AppScreen.Menu.route
    ) {
        composable(AppScreen.Menu.route) { MainMenuScreen(nav) }

        composable(AppScreen.Hidratacion.route) { HidratacionScreen() }

        composable(AppScreen.Estudio.route) { EstudioSemanalScreen() }

        composable(AppScreen.Transporte.route) { TransporteScreen() }
    }
}
