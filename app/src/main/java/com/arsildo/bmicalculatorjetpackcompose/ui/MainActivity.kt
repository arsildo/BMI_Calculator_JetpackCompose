package com.arsildo.bmicalculatorjetpackcompose.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.Green
import com.arsildo.bmicalculatorjetpackcompose.ui.theme.White


@Composable
fun MainActivityScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.TopCenter
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeightInput()
            WeightInput()
        }
    }
}

@Composable
fun HeightInput() {
    var text by remember { mutableStateOf("") }
    Row (
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Green,
                unfocusedIndicatorColor = Green,
                focusedIndicatorColor = White,
            ),
            onValueChange = { text = it },
            label = {
                Text(
                    text = "Height",
                    color = Green,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "CM",
            color = Green,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun WeightInput() {
    var text by remember { mutableStateOf("") }
    Row (
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = text,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Green,
                unfocusedIndicatorColor = Green,
                focusedIndicatorColor = White,
            ),
            maxLines = 1,
            onValueChange = { text = it },
            label = {
                Text(
                    text = "Weight",
                    color = Green,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "KG",
            color = Green,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )
    }
}