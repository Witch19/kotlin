package com.example.jetpck
//package com.example.obrafacil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.obrafacil.ui.Navigation
import com.example.obrafacil.ui.theme.ObraFacilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ObraFacilTheme {
                Navigation()
            }
        }
    }
}
