package com.example.introkotlin.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog // Added for AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import java.io.IOException // Import for IOException

class CapturarActivity : AppCompatActivity() {

    private lateinit var editTextSpanishWord: EditText
    private lateinit var editTextEnglishWord: EditText
    private lateinit var btnGuardar: Button
    private lateinit var textViewStatus: TextView
    private lateinit var btnRegresarMenuCapturar: Button

    private val fileName = "diccionario.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_capturar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainCapturar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        editTextSpanishWord = findViewById(R.id.editTextSpanishWord)
        editTextEnglishWord = findViewById(R.id.editTextEnglishWord)
        btnGuardar = findViewById(R.id.btnGuardar)
        textViewStatus = findViewById(R.id.textViewStatus)
        btnRegresarMenuCapturar = findViewById(R.id.btnRegresarMenuCapturar)

        btnGuardar.setOnClickListener {
            saveWordPair()
        }

        btnRegresarMenuCapturar.setOnClickListener {
            finish()
        }
    }

    private fun saveWordPair() {
        val spanishWord = editTextSpanishWord.text.toString().trim()
        val englishWord = editTextEnglishWord.text.toString().trim()

        if (spanishWord.isEmpty() || englishWord.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese ambas palabras.", Toast.LENGTH_SHORT).show()
            return
        }


        val wordPair = "$spanishWord=$englishWord\n"

        try {

            openFileOutput(fileName, MODE_APPEND).use {
                it.write(wordPair.toByteArray())
            }
            Toast.makeText(this, "Palabra guardada con éxito", Toast.LENGTH_SHORT).show()
            textViewStatus.text = "Palabras guardadas con éxito"
            textViewStatus.visibility = TextView.VISIBLE

            editTextSpanishWord.text.clear()
            editTextEnglishWord.text.clear()

        } catch (e: IOException) {
            e.printStackTrace()
            Toast.makeText(this, "Error al guardar: ${e.message}", Toast.LENGTH_LONG).show()
            textViewStatus.text = "Error al guardar las palabras"
            textViewStatus.visibility = TextView.VISIBLE
        }
    }
}