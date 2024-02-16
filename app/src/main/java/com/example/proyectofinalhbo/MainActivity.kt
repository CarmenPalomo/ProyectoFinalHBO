package com.example.proyectofinalhbo;

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

public class MainActivity : AppCompatActivity() {

    private lateinit var crearCuenta: Button
    private lateinit var iniciarSesion: Button
    private lateinit var  auth: FirebaseAuth
    private lateinit var email: EditText
    private lateinit var contraseña: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val analytics : FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Integracion de mensaje completada")
        analytics.logEvent("InitScreen", bundle)

        acceder()

    }

    private fun acceder(){
        crearCuenta = findViewById(R.id.botonRegistrarse)
        iniciarSesion = findViewById(R.id.BotonIniciaSesion)
        email = findViewById(R.id.correoElectronico)
        contraseña = findViewById(R.id.contraseña)
        val imagen = intent.getStringExtra("imagen")

        iniciarSesion.setOnClickListener {
            if (email.text.isNotEmpty() && contraseña.text.isNotEmpty()){
                auth.signInWithEmailAndPassword(email.text.toString(),
                    contraseña.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        val logged = Intent(this, InicioActivity::class.java)
                        logged.putExtra("email",email.text.toString())
                        logged.putExtra("imagen",  imagen)
                        startActivity(logged)
                    } else {
                        showAlert()
                    }
                }
            }
        }

        crearCuenta.setOnClickListener {
            val registrarse = Intent(this, LogingActivity::class.java)
            startActivity(registrarse)
        }
    }

    private fun showAlert(){
        Log.d(ContentValues.TAG, "Error creando nuevo usuario")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error en el login de usuario")
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}