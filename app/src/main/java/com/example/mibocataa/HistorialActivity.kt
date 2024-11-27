package com.example.mibocataa

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class HistorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.historial)

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

        val historialTotalBocadillos = listOf(
            "18/11/24: Bocadillo de pollo a la plancha",
            "21/11/24: Bocadillo de hamburguesa con bacon",
            "22/11/24: Bocadillo de ternera con champiñones"
        )

        val listViewHistorial = findViewById<ListView>(R.id.historialbocadillos)

        val adapterhistorial = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, historialTotalBocadillos
        )

        listViewHistorial.adapter = adapterhistorial
    }
}