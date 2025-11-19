package com.example.jetpck

import androidx.activity.compose.setContent
import com.example.clinicavetexpress.ui.Navigation
import com.example.clinicavetexpress.ui.theme.ClinicaVetExpressTheme

class MainActivityDos : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClinicaVetExpressTheme {
                Navigation()
            }
        }
    }
}