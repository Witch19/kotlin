package com.example.jetpck
//package com.example.soporte247

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.soporte247.ui.Navigation
import com.example.soporte247.ui.theme.Soporte247Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Soporte247Theme {
                Navigation()
            }
        }
    }
}
