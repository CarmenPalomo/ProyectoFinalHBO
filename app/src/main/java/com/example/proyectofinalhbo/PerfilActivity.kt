package com.example.proyectofinalhbo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity: AppCompatActivity() {

    private lateinit var usuario: Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imagenCasa: ImageView = findViewById(R.id.imagenCasa4)
        var textoNombre: TextView = findViewById(R.id.texoNombre)
        var textoApellido: TextView = findViewById(R.id.textoApellido)
        var textoEmail: TextView = findViewById(R.id.textoEmail)
        val imagenPerfil : ImageView = findViewById(R.id.imagePerfil)
        val imagen = intent.getStringExtra("imagen")
        usuario = intent.getParcelableExtra("Persona")!!

        imagenPerfil.setImageResource(usuario.getImagen())

        textoNombre.text = "${usuario.getNombre()}"
        textoApellido.text = "${usuario.getApellido()}"
        textoEmail.text = "${usuario.getEmail()}"





        imagenCasa.setOnClickListener {

            val inicio = Intent(this, InicioActivity::class.java)
            inicio.putExtra("Persona",  usuario)
            startActivity(inicio)

        }



    }
}