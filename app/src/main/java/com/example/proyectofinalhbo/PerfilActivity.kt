package com.example.proyectofinalhbo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly

class PerfilActivity: AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imagenCasa: ImageView = findViewById(R.id.imagenCasa)

        val imagenPerfil : ImageView = findViewById(R.id.imagePerfil)
        val botonSiguiente : Button = findViewById(R.id.BotonSiguiente)
        val imagen = intent.getStringExtra("imagen")






        imagenCasa.setOnClickListener {

            val inicio = Intent(this, InicioActivity::class.java)
            startActivity(inicio)

        }



    }
}