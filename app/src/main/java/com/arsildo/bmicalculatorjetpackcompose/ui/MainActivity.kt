package com.arsildo.bmicalculatorjetpackcompose.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.*


// MAIN AND ONLY SCREEN CHECK OUT RELATED COMMENTS

@Composable
fun MainActivityScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize() // Fill whole screen
            .background(Black),
        contentAlignment = Alignment.TopCenter
    ) {
        // Call the Composable Function
        CalculateBMI()
    }
}

@Composable
fun CalculateBMI() {
    // Marked all the changing parts of the app with mutable states
    val context = LocalContext.current
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var classification by remember { mutableStateOf("") }
    var calculation by remember { mutableStateOf(0.0f) }
    var progress by remember { mutableStateOf(0.0f) }
    var classificationColor by remember {
        mutableStateOf(Color.White)
    }

    Column(
        Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth(),
            contentAlignment = Center
        ) {
            Text(
                text = "Calculate BMI",
                color = Green,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        Text(
            text = "EU Metrics",
            color = White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )

        TextFieldComponent(
            inputValue = height,
            metric = "cm",
            label = "Height",
            onValueChange = {
                height = it
                if (height.isEmpty() || weight.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Make sure to fill out everything!",
                        Toast.LENGTH_SHORT
                    ).show()
                    classification = ""
                    calculation = 0f
                    progress = 0f
                } else {
                    calculation = computeBMI(height, weight)
                    if (calculation < 18.5) {
                        classification = "Underweight"
                        progress= .1f
                        classificationColor = Blue
                    } else if (calculation >= 18.5 && calculation < 24.9) {
                        classification = "Healthy"
                        progress = .5f
                        classificationColor = Green
                    } else if (calculation >= 24.9 && calculation < 30) {
                        classification = "Overweight"
                        progress = .75f
                        classificationColor = DarkRed
                    } else if (calculation >= 30) {
                        classification = "Suffering from Obesity"
                        progress = 1f
                        classificationColor = Red
                    }
                }

            }
        )
        TextFieldComponent(
            inputValue = weight,
            metric = "kg",
            label = "Weight",
            onValueChange = {
                weight = it
                if (height.isEmpty() || weight.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Make sure to fill out everything!",
                        Toast.LENGTH_SHORT
                    ).show()
                    classification = ""
                    calculation = 0f
                    progress = 0f
                } else {
                    calculation = computeBMI(height, weight)
                    if (calculation < 18.5) {
                        classification = "Underweight"
                        progress= .1f
                        classificationColor = Blue
                    } else if (calculation >= 18.5 && calculation < 24.9) {
                        classification = "Healthy"
                        progress = .5f
                        classificationColor = Green
                    } else if (calculation >= 24.9 && calculation < 30) {
                        classification = "Overweight"
                        progress = .75f
                        classificationColor = DarkRed
                    } else if (calculation >= 30) {
                        classification = "Suffering from Obesity"
                        progress = 1f
                        classificationColor = Red
                    }
                }
            }
        )

        Box(Modifier.padding(vertical = 16.dp), contentAlignment = Center) {
            Text(
                text = classification,
                color = classificationColor,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // Circular Progress bar with text in the center Custom Box
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 64.dp)
                .size(250.dp),
            contentAlignment = Center
        ) {
            Text(
                text = String.format("%.2f", calculation), // Format Result
                color = White,
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
            CircularProgressIndicator(
                progress = progress,
                color = classificationColor,
                strokeWidth = 16.dp,
                modifier = Modifier.fillMaxSize(),
            )
        }

    }
}

