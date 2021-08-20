package com.arsildo.bmicalculatorjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.arsildo.bmicalculatorjetpackcompose.ui.MainActivityScreen
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.BMICalculatorJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorJetpackComposeTheme {
                MainActivityScreen()
            }
        }
    }
}