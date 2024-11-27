package com.example.mibocataa

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.perfil)

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

    }
}