package com.example.proyectofinalhbo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView


class InicioActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val imagenCasa: ImageView = findViewById(R.id.imagenCasa)
        val imagenPeli: ImageView = findViewById(R.id.imagePeli)
        val imagenTele : ImageView = findViewById(R.id.imageTele)
        val imagenPerfil : ImageView = findViewById(R.id.imagenPerfil)
        val scrollDestacados : HorizontalScrollView = findViewById(R.id.scrollDestacados)
        val scrollPeliculas : HorizontalScrollView = findViewById(R.id.scrollPeliculas)
        val scrollSeries : HorizontalScrollView = findViewById(R.id.scrollSeries)
        val textoDestacado : TextView = findViewById(R.id.textoDestacado)
        val textPeliculas : TextView = findViewById(R.id.textPeliculas)
        val textSerie : TextView = findViewById(R.id.textSerie)
        val imagen1Destacado : ImageView = findViewById(R.id.imagen1Destacado)


        imagenCasa.setOnClickListener {

            val inicio = Intent(this, InicioActivity::class.java)
            startActivity(inicio)
            textoDestacado.visibility = View.VISIBLE
            scrollDestacados.visibility = View.VISIBLE

            textPeliculas.visibility = View.INVISIBLE
            textSerie.visibility = View.INVISIBLE
            scrollPeliculas.visibility = View.INVISIBLE
            scrollSeries.visibility = View.INVISIBLE

        }

        imagen1Destacado.setOnClickListener {
            val inicio = Intent(this, Imagen1DestacadoActivity::class.java)
            startActivity(inicio)
        }

        imagenPeli.setOnClickListener {

            textPeliculas.visibility = View.VISIBLE
            scrollPeliculas.visibility = View.VISIBLE

            textoDestacado.visibility = View.INVISIBLE
            textSerie.visibility = View.INVISIBLE
            scrollDestacados.visibility = View.INVISIBLE
            scrollSeries.visibility = View.INVISIBLE


        }

        imagenTele.setOnClickListener {

            scrollSeries.visibility = View.VISIBLE
            textSerie.visibility = View.VISIBLE


            textPeliculas.visibility = View.INVISIBLE
            textoDestacado.visibility = View.INVISIBLE
            scrollDestacados.visibility = View.INVISIBLE
            scrollPeliculas.visibility = View.INVISIBLE


        }

        imagenPerfil.setOnClickListener {

            val perfil = Intent(this, PerfilActivity::class.java)
            startActivity(perfil)

        }

    }
}