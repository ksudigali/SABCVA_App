package com.sabcva.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sabcva.app.ui.theme.SABCVAAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SABCVAAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CreateAnnouncementScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
