package com.arsildo.bmicalculatorjetpackcompose.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.*

@Composable
fun Body() {
    // Marked all the changing parts of the app with mutable states
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var classification by remember { mutableStateOf("") }
    var calculation by remember { mutableStateOf(0.0f) }
    var progress by remember { mutableStateOf(0.0f) }
    var classificationColor by remember {
        mutableStateOf(Color.White)
    }

    Column(
        Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Text(
            text = "Calculate BMI",
            color = Green,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
        )
        Text(
            text = "EU Metrics",
            color = White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
        // Custom TextField Component
        TextFieldComponent(
            inputValue = height,
            metric = "cm",
            label = "Height",
            onValueChange = {
                height = it
                if (height.isEmpty() || weight.isEmpty()) {
                    classification = ""
                    calculation = 0f
                    progress = 0f
                } else {
                    calculation = computeBMI(height, weight)
                    calculation = computeBMI(height, weight)
                    classification = classifyBMI(calculation)
                    progress = getProgress(calculation)
                    classificationColor = getClassificationColor(calculation)
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
                    classification = ""
                    calculation = 0f
                    progress = 0f
                } else {
                    calculation = computeBMI(height, weight)
                    classification = classifyBMI(calculation)
                    progress = getProgress(calculation)
                    classificationColor = getClassificationColor(calculation)
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

// LOGIC FUNCTION TO CATEGORIZE WEIGHT COMPUTATION
fun classifyBMI(
    calculation: Float
): String {
    var classification = ""
    if (calculation < 18.5) {
        classification = "Underweight"
    } else if (calculation >= 18.5 && calculation < 24.9) {
        classification = "Healthy"
    } else if (calculation >= 24.9 && calculation < 30) {
        classification = "Overweight"
    } else if (calculation >= 30) {
        classification = "Suffering from Obesity"
    }
    return classification
}

fun getProgress(
    calculation: Float
): Float {
    var progress = 0f
    if (calculation < 18.5) {
        progress = .1f
    } else if (calculation >= 18.5 && calculation < 24.9) {
        progress = .5f
    } else if (calculation >= 24.9 && calculation < 30) {
        progress = .75f
    } else if (calculation >= 30) {
        progress = 1f
    }
    return progress
}

fun getClassificationColor(
    calculation: Float
): Color {
    var classificationColor = White
    if (calculation < 18.5) {
        classificationColor = Blue
    } else if (calculation >= 18.5 && calculation < 24.9) {
        classificationColor = Green
    } else if (calculation >= 24.9 && calculation < 30) {
        classificationColor = DarkRed
    } else if (calculation >= 30) {
        classificationColor = Red
    }
    return classificationColor
}