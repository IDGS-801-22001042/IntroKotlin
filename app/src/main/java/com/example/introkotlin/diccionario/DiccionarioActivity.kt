package com.example.introkotlin.diccionario

import android.content.Intent
import android.os.Bundle
import android.widget.Button // Import Button
import android.widget.TextView // Import TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import com.example.introkotlin.ejemplo1.SumaActivity

class DiccionarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_diccionario)

        val btnCapturar: Button = findViewById(R.id.btnCapturar)
        btnCapturar.setOnClickListener { navegateToCapturar() }
        val btnBuscar: Button = findViewById(R.id.btnBuscar)
        btnBuscar.setOnClickListener { navegateToBuscar() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    private fun navegateToCapturar() {
        val intent = Intent(this, CapturarActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToBuscar() {
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }
}