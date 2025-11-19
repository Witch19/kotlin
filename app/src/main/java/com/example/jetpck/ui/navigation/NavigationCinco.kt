package com.example.jetpck.ui.navigation

//package com.example.obrafacil.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.*
import com.example.obrafacil.ui.screens.*

sealed class AppScreen(val route: String) {
    object Menu : AppScreen("menu")
    object Mezcla : AppScreen("mezcla")
    object Ladrillos : AppScreen("ladrillos")
    object ManoObra : AppScreen("manoobra")
}

@Composable
fun Navigation() {
    val nav = rememberNavController()

    NavHost(navController = nav, startDestination = AppScreen.Menu.route) {
        composable(AppScreen.Menu.route) { MainMenuScreen(nav) }
        composable(AppScreen.Mezcla.route) { MezclaConcretoScreen() }
        composable(AppScreen.Ladrillos.route) { LadrillosScreen() }
        composable(AppScreen.ManoObra.route) { ManoObraScreen() }
    }
}





