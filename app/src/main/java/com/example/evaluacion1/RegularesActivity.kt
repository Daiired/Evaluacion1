package com.example.evaluacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegularesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regulares)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener{
            val resultado = findViewById<TextView>(R.id.tvResultado)

            val sueldo = findViewById<EditText>(R.id.etSueldoBruto)

            val s: Double = sueldo.text.toString().toDoubleOrNull()?:0.0

            val empleado = EmpleadoRegular(s)
            val sueldoFinal = empleado.calcularLiquido()
            resultado.text ="Su sueldo final es: ${sueldoFinal}"
        }

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}