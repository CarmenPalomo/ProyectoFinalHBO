package com.example.proyectofinalhbo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView

class Imagen1DestacadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imagen1_destacado)


        val video : VideoView = findViewById(R.id.video)

        val uri : Uri = Uri.parse("https://www.youtube.com/watch?v=nDxAQ9FUhr8")

        video.setMediaController(MediaController(this))
        video.setVideoURI(uri)
        video.requestFocus()
        video.start()

    }
}