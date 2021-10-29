package com.arsildo.bmicalculatorjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.arsildo.bmicalculatorjetpackcompose.ui.Body
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.BMICalculatorJetpackComposeTheme
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.Black

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorJetpackComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color =  Black
                ){
                    Body()
                }
            }
        }
    }
}