package com.example.proyectofinalhbo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView

class Pelicula3Activity : AppCompatActivity() {
    var video : VideoView? = null
    var mediaController : MediaController? = null
    private lateinit var usuario: Usuario
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pelicula3)
        val imagenCasa: ImageView = findViewById(R.id.imagenCasa8)
        var imagenPerfil : ImageView = findViewById(R.id.imagenPerfil8)
        usuario = intent.getParcelableExtra("Persona")!!

        imagenPerfil.setImageResource(usuario.getImagen())
        video = findViewById(R.id.video8)

        if (mediaController == null){
            mediaController = MediaController(this)
            mediaController!!.setAnchorView(this.video)

        }

        video!!.setMediaController(mediaController)
        video!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.el_discurso))
        video!!.requestFocus()
        video!!.start()

        video!!.setOnCompletionListener {
            Toast.makeText(applicationContext, "Video End", Toast.LENGTH_LONG).show()

        }

        video!!.setOnErrorListener { mediaPlayer, i, i2 ->
            Toast.makeText(applicationContext, "Error Ocurred", Toast.LENGTH_LONG).show()
            false
        }


        imagenCasa.setOnClickListener {

            val inicio = Intent(this, InicioActivity::class.java)
            inicio.putExtra("Persona",  usuario)
            startActivity(inicio)

        }
    }
}