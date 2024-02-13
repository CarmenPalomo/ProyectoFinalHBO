package com.example.proyectofinalhbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView


class InicioActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val imagenCasa: ImageView = findViewById(R.id.imagenCasa)
        val imagenPeli: ImageView = findViewById(R.id.imagePeli)
        val imagenTele : ImageView = findViewById(R.id.imageTele)
        val imagenPerfil : ImageView = findViewById(R.id.imagenPerfil)



        imagenCasa.setOnClickListener {

            val inicio = Intent(this, InicioActivity::class.java)
            startActivity(inicio)

        }

        imagenPeli.setOnClickListener {

            val pelicula = Intent(this, PeliculaActivity::class.java)
            startActivity(pelicula)

        }

        imagenTele.setOnClickListener {

            val serie = Intent(this, SerieActivity::class.java)
            startActivity(serie)

        }

        imagenPerfil.setOnClickListener {

            val perfil = Intent(this, PerfilActivity::class.java)
            startActivity(perfil)

        }

    }
}