package com.example.introkotlin.diccionario

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.introkotlin.R
import java.io.FileNotFoundException // Import for FileNotFoundException
import java.io.IOException // Import for IOException

class BuscarActivity : AppCompatActivity() {

    private lateinit var radioGroupSearchLanguage: RadioGroup
    private lateinit var radioSpanish: RadioButton
    private lateinit var radioEnglish: RadioButton
    private lateinit var editTextSearchWord: EditText
    private lateinit var btnBuscar: Button
    private lateinit var textViewFoundWord: TextView
    private lateinit var btnRegresarMenuBuscar: Button

    private val fileName = "diccionario.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainBuscar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        radioGroupSearchLanguage = findViewById(R.id.radioGroupSearchLanguage)
        radioSpanish = findViewById(R.id.radioSpanish)
        radioEnglish = findViewById(R.id.radioEnglish)
        editTextSearchWord = findViewById(R.id.editTextSearchWord)
        btnBuscar = findViewById(R.id.btnBuscar)
        textViewFoundWord = findViewById(R.id.textViewFoundWord)
        btnRegresarMenuBuscar = findViewById(R.id.btnRegresarMenuBuscar)

        btnBuscar.setOnClickListener {
            buscarPalabra()
        }

        btnRegresarMenuBuscar.setOnClickListener {
            finish()
        }
    }

    private fun buscarPalabra() {
        val wordToSearch = editTextSearchWord.text.toString().trim()
        if (wordToSearch.isEmpty()) {
            Toast.makeText(this, "Por favor, ingrese la palabra a buscar.", Toast.LENGTH_SHORT).show()
            textViewFoundWord.visibility = TextView.GONE
            return
        }

        val searchInSpanish = radioSpanish.isChecked
        var foundTranslation: String? = null

        try {
            val content = openFileInput(fileName).bufferedReader().useLines { lines ->
                lines.toList()
            }

            for (line in content) {

                val parts = line.split("=")
                if (parts.size == 2) {
                    val spanish = parts[0].trim().lowercase()
                    val english = parts[1].trim().lowercase()

                    if (searchInSpanish) {

                        if (spanish == wordToSearch.lowercase()) {
                            foundTranslation = english
                            break
                        }
                    } else {

                        if (english == wordToSearch.lowercase()) {
                            foundTranslation = spanish
                            break
                        }
                    }
                }
            }

            if (foundTranslation != null) {
                textViewFoundWord.text = "Traducción: $foundTranslation"
                textViewFoundWord.visibility = TextView.VISIBLE
            } else {
                textViewFoundWord.text = "Palabra no encontrada"
                textViewFoundWord.visibility = TextView.VISIBLE
                Toast.makeText(this, "Palabra no encontrada", Toast.LENGTH_SHORT).show()
            }

        } catch (e: FileNotFoundException) {
            textViewFoundWord.text = "Archivo de diccionario no encontrado."
            textViewFoundWord.visibility = TextView.VISIBLE
            Toast.makeText(this, "El diccionario está vacío o no existe.", Toast.LENGTH_LONG).show()
        } catch (e: IOException) {
            e.printStackTrace()
            textViewFoundWord.text = "Error al leer el archivo: ${e.message}"
            textViewFoundWord.visibility = TextView.VISIBLE
            Toast.makeText(this, "Error al buscar: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }
}