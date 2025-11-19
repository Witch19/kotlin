package com.example.jetpck

//package com.example.tallerpro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.tallerpro.ui.Navigation
import com.example.tallerpro.ui.theme.TallerProTheme

class MainActivityTres : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TallerProTheme {
                Navigation()
            }
        }
    }
}
