package com.example.evaluacion1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evaluacion1.ui.theme.Evaluacion1Theme

class HorariosActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Horarios()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Horarios() {
    var sueldoBruto by remember { mutableStateOf("") }
    var texto by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calcular Sueldo Empleado Horario",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            placeholder = { Text(text = "Sueldo bruto") },
            value = sueldoBruto,
            onValueChange = { sueldoBruto = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val sueldo: Double = sueldoBruto.toDoubleOrNull() ?: 0.0
            val resultado: Double = EmpleadoHorario(sueldo).calcularLiquido()
            texto = "Su sueldo final es: ${resultado}"
        }) {
            Text(text = "Calcular Sueldo")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = texto)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        }) {
            Text(text = "<-Volver")
        }
    }
}