package com.example.proyectofinalhbo

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Logger

class PerfilActivity: AppCompatActivity() {
    private val log: Logger = Logger.getLogger("PerfilActivity")

    private lateinit var usuario: Usuario
    private lateinit var cambiarNombreText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        val imagenCasa: ImageView = findViewById(R.id.imagenCasa4)
        val cambiarNombre: Button = findViewById(R.id.cambiarNombre)
        val cambiar: Button = findViewById(R.id.cambiar)
        cambiarNombreText = findViewById(R.id.cambiarNombreTexto)

        var textoNombre: TextView = findViewById(R.id.texoNombre)
        var textoApellido: TextView = findViewById(R.id.textoApellido)
        var textoEmail: TextView = findViewById(R.id.textoEmail)
        val imagenPerfil : ImageView = findViewById(R.id.imagePerfil)

        val imagen = intent.getStringExtra("imagen")
        usuario = intent.getParcelableExtra("Persona")!!
        log.info("persona obtenida :: $usuario")
        imagenPerfil.setImageResource(usuario.getImagen())

        textoNombre.text = "${usuario.getNombre()}"
        textoApellido.text = "${usuario.getApellido()}"
        textoEmail.text = "${usuario.getEmail()}"

        imagenCasa.setOnClickListener {
            val inicio = Intent(this, InicioActivity::class.java)
            inicio.putExtra("Persona",  usuario)
            startActivity(inicio)
        }

        cambiarNombre.setOnClickListener {
            textoNombre.visibility = View.INVISIBLE
            textoApellido.visibility = View.INVISIBLE
            textoEmail.visibility = View.INVISIBLE

            cambiarNombreText.visibility = View.VISIBLE
            cambiar.visibility = View.VISIBLE
            cambiarNombre.visibility = View.GONE
        }

        cambiar.setOnClickListener {
            usuario.setNombre(cambiarNombreText.text.toString())
            textoNombre.text = "${usuario.getNombre()}"


            textoNombre.visibility = View.VISIBLE
            textoApellido.visibility = View.VISIBLE
            textoEmail.visibility = View.VISIBLE

            cambiarNombreText.visibility = View.INVISIBLE
            cambiarNombre.visibility = View.VISIBLE
            cambiar.visibility = View.GONE
        }


    }
}