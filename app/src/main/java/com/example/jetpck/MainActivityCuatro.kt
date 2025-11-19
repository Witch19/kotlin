package com.example.jetpck

//package com.example.mipanaderia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mipanaderia.ui.Navigation
import com.example.mipanaderia.ui.theme.MiPanaderiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiPanaderiaTheme { Navigation() }
        }
    }
}
