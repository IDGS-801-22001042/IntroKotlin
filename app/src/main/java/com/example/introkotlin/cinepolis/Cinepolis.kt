package com.example.introkotlin.cinepolis

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.introkotlin.R
import java.text.NumberFormat
import java.util.Locale

class Cinepolis : AppCompatActivity() {

    private lateinit var etComprador: EditText
    private lateinit var etPersonas: EditText
    private lateinit var etBoletos: EditText
    private lateinit var rdTarjeta: RadioGroup
    private lateinit var btnCalcular: Button
    private lateinit var textViewTicketsToPayResult: TextView
    private lateinit var textViewTotalAmountResult: TextView

    private val precioBoleto = 12.0
    private val descuentoTarjetaCine = 0.10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinepolis)

        etComprador = findViewById(R.id.etComprador)
        etPersonas = findViewById(R.id.etPersonas)
        etBoletos = findViewById(R.id.etBoletos)
        rdTarjeta = findViewById(R.id.rdTarjeta)
        btnCalcular = findViewById(R.id.btnCalcular)
        textViewTicketsToPayResult = findViewById(R.id.textViewTicketsToPayResult)
        textViewTotalAmountResult = findViewById(R.id.textViewTotalAmountResult)

        btnCalcular.setOnClickListener {
            procesarCompra()
        }
    }

    private fun procesarCompra() {
        val nombre = etComprador.text.toString().trim()
        val personasStr = etPersonas.text.toString().trim()
        val boletosStr = etBoletos.text.toString().trim()

        if (nombre.isEmpty() || personasStr.isEmpty() || boletosStr.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos.", Toast.LENGTH_SHORT).show()
            return
        }

        val personas = personasStr.toIntOrNull()
        val boletos = boletosStr.toIntOrNull()

        if (personas == null || boletos == null || personas <= 0 || boletos <= 0) {
            Toast.makeText(this, "Ingresa números válidos para personas y boletos.", Toast.LENGTH_SHORT).show()
            return
        }

        val maxPermitido = personas * 7
        if (boletos > maxPermitido) {
            Toast.makeText(this, "Máximo permitido: $maxPermitido boletos para $personas persona(s).", Toast.LENGTH_LONG).show()
            return
        }

        val subtotal = boletos * precioBoleto
        var descuento = 0.0

        // Descuento por cantidad
        descuento += when {
            boletos > 5 -> subtotal * 0.15
            boletos in 3..5 -> subtotal * 0.10
            else -> 0.0
        }

        val tarjetaSeleccionada = findViewById<RadioButton>(rdTarjeta.checkedRadioButtonId)?.id
        val usaTarjeta = tarjetaSeleccionada == R.id.radioButtonCardYes

        // Descuento por tarjeta
        if (usaTarjeta) {
            descuento += (subtotal - descuento) * descuentoTarjetaCine
        }

        val total = subtotal - descuento

        textViewTicketsToPayResult.text = boletos.toString()
        textViewTotalAmountResult.text = formatCurrency(total)

        Toast.makeText(
            this,
            "Total a pagar: ${formatCurrency(total)}\nDescuento aplicado: ${formatCurrency(descuento)}",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun formatCurrency(cantidad: Double): String {
        val formato = NumberFormat.getCurrencyInstance(Locale("es", "MX"))
        return formato.format(cantidad)
    }
}
