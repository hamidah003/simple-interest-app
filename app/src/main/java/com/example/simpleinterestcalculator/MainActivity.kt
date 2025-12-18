package com.example.simpleinterestcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simpleinterestcalculator.ui.theme.SimpleInterestCalculatorTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleInterestCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SimpleInterestCalculator()
                }
            }
        }
    }
}

@Composable
fun SimpleInterestCalculator() {
    var principal by remember { mutableStateOf("") }
    var rate by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var simpleInterest by remember { mutableStateOf<Double?>(null) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        OutlinedTextField(
            value = principal,
            onValueChange = { principal = it },
            label = { Text("Principal") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = rate,
            onValueChange = { rate = it },
            label = { Text("Rate (%)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text("Time (years)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val p = principal.toDoubleOrNull() ?: 0.0
                val r = rate.toDoubleOrNull() ?: 0.0
                val t = time.toDoubleOrNull() ?: 0.0
                simpleInterest = (p * r * t) / 100
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calculate")
        }
        simpleInterest?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text("Simple Interest: $it")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleInterestCalculatorTheme {
        SimpleInterestCalculator()
    }
}
