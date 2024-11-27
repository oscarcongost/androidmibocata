package com.example.mibocataa

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val usuario = findViewById<EditText>(R.id.usuario)
        val contrasenia = findViewById<EditText>(R.id.contrasenia)
        val botonLogin = findViewById<MaterialButton>(R.id.botonlogin)

        val user = "admin"
        val password = "1234"

        botonLogin.setOnClickListener {
            val inputUsuario = usuario.text.toString()
            val inputContrasenia = contrasenia.text.toString()

            if (inputUsuario == user && inputContrasenia == password) {
                val intent = Intent(this, SeleccionActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
