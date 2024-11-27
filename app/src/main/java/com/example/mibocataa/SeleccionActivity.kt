package com.example.mibocataa

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.time.LocalDate

class SeleccionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seleccion)

        val botonProximo = findViewById<ImageView>(R.id.calendario)
        val botonHistorial = findViewById<ImageView>(R.id.historial)
        val botonPerfil = findViewById<ImageView>(R.id.perfil)
        val botonSeleccion = findViewById<ImageView>(R.id.logoarribabocata)

        botonSeleccion.setOnClickListener {
            val intent = Intent(this, SeleccionActivity::class.java)
            startActivity(intent)
        }

        botonProximo.setOnClickListener {
            val intent = Intent(this, ProximoActivity::class.java)
            startActivity(intent)
        }

        botonHistorial.setOnClickListener {
            val intent = Intent(this, HistorialActivity::class.java)
            startActivity(intent)
        }

        botonPerfil.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
        }

        fun diaActual(): String {
            val diaactual = LocalDate.now()
            return diaactual.dayOfWeek.toString()
        }

        fun cargarBocadillosDesdeJson(): BocadilloDiaMasUno {
            val inputStream = resources.openRawResource(R.raw.bocadillosemana)
            val lector = InputStreamReader(inputStream)
            val tipo = object : TypeToken<BocadilloDiaMasUno>() {}.type
            return Gson().fromJson(lector, tipo)
        }

        val bocadillosemanal = cargarBocadillosDesdeJson()
        val diaactual = diaActual()

        val bocadillocaliente = bocadillosemanal.bocadilloscalientes[diaactual]
        val bocadillofrio = bocadillosemanal.bocadillosfrios[diaactual]

        val textocalientes = findViewById<TextView>(R.id.descripcioncaliente)
        val textofrios = findViewById<TextView>(R.id.descripcionfrio)

        textofrios.text = bocadillofrio ?: "No hay bocadillos"
        textocalientes.text = bocadillocaliente ?: "No hay bocadillos"

    }
}