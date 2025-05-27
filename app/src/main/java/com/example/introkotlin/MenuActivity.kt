package com.example.introkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import com.example.introkotlin.cinepolis.Cinepolis
import com.example.introkotlin.diccionario.DiccionarioActivity
import com.example.introkotlin.ejemplo1.SumaActivity
import com.example.introkotlin.ejemplo2.SaludoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btn1)
        btnSaludo.setOnClickListener { navegateToSaludo() }

        val btnCinepolis = findViewById<Button>(R.id.btn2)
        btnCinepolis.setOnClickListener { navegateToCinepolis() }

        val btnSaludo2 = findViewById<Button>(R.id.btn3)
        btnSaludo2.setOnClickListener { navegateToSaludo2() }

        val btnDiccionario = findViewById<Button>(R.id.btn4)
        btnDiccionario.setOnClickListener { navegateToDiccionario() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navegateToSaludo() {
        val intent = Intent(this, SumaActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToCinepolis() {
        val intent = Intent(this, Cinepolis::class.java)
        startActivity(intent)
    }

    private fun navegateToSaludo2() {
        val intent = Intent(this, SaludoActivity::class.java)
        startActivity(intent)
    }

    private fun navegateToDiccionario() {
        val intent = Intent(this, DiccionarioActivity::class.java)
        startActivity(intent)
    }
}