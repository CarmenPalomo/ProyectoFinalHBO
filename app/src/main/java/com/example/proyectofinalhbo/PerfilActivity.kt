package com.example.proyectofinalhbo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity: AppCompatActivity() {

    private var indice = 0
    private var id = arrayOf(R.mipmap.perfil1, R.mipmap.perfil2,R.mipmap.perfil3,
                             R.mipmap.perfil4, R.mipmap.perfil5, R.mipmap.perfil6,
                             R.mipmap.perfil7, R.mipmap.perfil8, R.mipmap.perfil9,
                             R.mipmap.perfil10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imagenCasa: ImageView = findViewById(R.id.imagenCasa)
        val imagenPeli: ImageView = findViewById(R.id.imagePeli)
        val imagenTele : ImageView = findViewById(R.id.imageTele)

        val imagenPerfil : ImageView = findViewById(R.id.imagePerfil)
        val botonSiguiente : Button = findViewById(R.id.BotonSiguiente)

        imagenPerfil.setImageResource(id[indice])
        botonSiguiente.setOnClickListener {
            indice = (indice + 1) % id.size

            imagenPerfil.setImageResource(id[indice])
        }

        imagenCasa.setOnClickListener {

            val inicio = Intent(this, InicioActivity::class.java)
            startActivity(inicio)

        }

        imagenPeli.setOnClickListener {

            val pelicula = Intent(this, InicioActivity::class.java)
            startActivity(pelicula)

        }

        imagenTele.setOnClickListener {

            val serie = Intent(this, InicioActivity::class.java)
            startActivity(serie)

        }

    }
}