package com.example.introkotlin.ejemplo2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R

class SaludoActivity : AppCompatActivity() {
    private lateinit var result: AppCompatTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_saludo)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val edtName = findViewById<AppCompatEditText>(R.id.edtName)
        result = findViewById(R.id.textView)
        val name: String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        result.text = "Hola $name"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnStart.setOnClickListener {
            val name = edtName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, resultado::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }else{
                edtName.error = "Por favor escribe tu nombre"
            }

        }
    }
}