package com.example.introkotlin.ejemplo1

import android.os.Bundle
import android.widget.EditText
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class SumaActivity : AppCompatActivity() {

    private lateinit var et1: EditText
    private lateinit var et2: EditText
    private lateinit var tv1: TextView
    private lateinit var radioGroupOperaciones: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_suma)

        et1 = findViewById(R.id.et1)
        et2 = findViewById(R.id.et2)
        tv1 = findViewById(R.id.tv1)
        radioGroupOperaciones = findViewById(R.id.radioGroupOperaciones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View?) {

        val num1 = et1.text.toString().toDouble()
        val num2 = et2.text.toString().toDouble()

        val selectedRadioButtonId = radioGroupOperaciones.checkedRadioButtonId

        var resultado: Double? = null
        var operacionTexto = ""

        when (selectedRadioButtonId) {
            R.id.rdSuma -> {
                resultado = num1 + num2
                operacionTexto = "Suma"
            }
            R.id.rdResta -> {
                resultado = num1 - num2
                operacionTexto = "Resta"
            }
            R.id.rdMultiplicacion -> {
                resultado = num1 * num2
                operacionTexto = "Multiplicación"
            }
            R.id.rdDivision -> {
                resultado = num1 / num2
                operacionTexto = "División"
            }
        }
        if (resultado != null) {
            val resultadoFormateado = if (resultado % 1 == 0.0) {
            } else {
            }
            tv1.text = "Resultado $operacionTexto: ${resultado}"
        } else {
            tv1.text = "Resultado: Selecciona operación"
        }
    }
}