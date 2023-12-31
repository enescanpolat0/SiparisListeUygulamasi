package com.enescanpolat.siparislisteuygulamasi

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.enescanpolat.siparislisteuygulamasi.presentation.Navigation
import com.enescanpolat.siparislisteuygulamasi.ui.theme.Orange
import com.enescanpolat.siparislisteuygulamasi.ui.theme.SiparisListeUygulamasiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            window.statusBarColor = Orange.toArgb()
            window.navigationBarColor = Orange.toArgb()
            SiparisListeUygulamasiTheme {
                // A surface container using the 'background' color from the theme
               Navigation()
            }
        }
    }
}

