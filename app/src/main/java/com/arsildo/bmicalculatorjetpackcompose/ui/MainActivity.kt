package com.arsildo.bmicalculatorjetpackcompose.ui

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.Green


@Composable
fun MainActivityScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            CalculateBMI()
        }
    }
}

@Composable
fun CalculateBMI() {
    
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    
    Column(
        Modifier.padding(horizontal = 16.dp,vertical = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Box(
            Modifier.padding(vertical = 16.dp).fillMaxWidth(),
            contentAlignment = Center
        ) {
            Text(
                text = "Calculate BMI",
                color = Green,
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
            )
        }
        
        Row (
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ){
            TextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Height") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Green
                ),
            )
            Text(text = "cm",Modifier.padding(horizontal = 8.dp))
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center
        ){
            TextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Weight") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Green
                )
            )
            Text(text = "kg",Modifier.padding(horizontal = 8.dp))
        }
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp,vertical = 64.dp)
                .size(256.dp),
            contentAlignment = Center
        ){
            Text(
                text = "18.5",
                fontSize = 64.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Medium,
            )
            CircularProgressIndicator(
                progress = .95f,
                strokeWidth = 16.dp,
                modifier = Modifier.fillMaxSize(),
            )
        }

    }


}
