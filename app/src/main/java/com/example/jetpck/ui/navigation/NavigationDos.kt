package com.example.jetpck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clinicavetexpress.ui.screens.*

sealed class AppScreen(val route: String) {
    object Menu : AppScreen("menu")
    object Dosis : AppScreen("dosis")
    object Plan : AppScreen("plan")
    object Costo : AppScreen("costo")
}

@Composable
fun Navigation() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = AppScreen.Menu.route) {

        composable(AppScreen.Menu.route) { MainMenuScreen(nav) }
        composable(AppScreen.Dosis.route) { DosisMedicamentoScreen() }
        composable(AppScreen.Plan.route) { PlanAlimentacionScreen() }
        composable(AppScreen.Costo.route) { CostoVisitaVacunasScreen() }
    }
}


