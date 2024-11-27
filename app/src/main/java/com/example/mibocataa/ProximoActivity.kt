package com.example.mibocataa

import android.content.Intent
import android.os.Bundle
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.time.LocalDate

class ProximoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.proximo)

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

        fun diaMasUno(): String {
            val dia = LocalDate.now().plusDays(1)
            return dia.dayOfWeek.toString()
        }

        fun cargarBocadillosDesdeJson(): BocadilloDiaMasUno {
            val inputStream = resources.openRawResource(R.raw.bocadillosemana)
            val lector = InputStreamReader(inputStream)
            val tipo = object : TypeToken<BocadilloDiaMasUno>() {}.type
            return Gson().fromJson(lector, tipo)
        }

        val bocadillomanana = cargarBocadillosDesdeJson()
        val diaMasUno = diaMasUno()

        val bocadillocaliente = bocadillomanana.bocadilloscalientes[diaMasUno]
        val bocadillofrio = bocadillomanana.bocadillosfrios[diaMasUno]

        val textocalientes = findViewById<TextView>(R.id.proximocaliente)
        val textofrios = findViewById<TextView>(R.id.proximofrio)

        textofrios.text = bocadillofrio ?: "No hay bocadillos"
        textocalientes.text = bocadillocaliente ?: "No hay bocadillos"


        fun cargarBocadillosSemanaDesdeJson(): BocadilloSemana {
            val inputStream = resources.openRawResource(R.raw.bocadilloproximo)
            val lector = InputStreamReader(inputStream)
            val tipo = object : TypeToken<BocadilloSemana>() {}.type
            return Gson().fromJson(lector, tipo)
        }

        val bocadilloSemana = cargarBocadillosSemanaDesdeJson()

        val bocadillosMap = bocadilloSemana.bocadillos
        bocadillosMap

        val gridView: GridView = findViewById(R.id.gridbocadillossemana)
        val adapter = BocadilloSemanaAdapter(this, bocadillosMap)
        gridView.adapter = adapter

    }
}