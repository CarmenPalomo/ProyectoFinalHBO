package com.example.proyectopractica

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class LogingActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var database : FirebaseDatabase
    private lateinit var usuariosRef : DatabaseReference

    private lateinit var correo : EditText
    private lateinit var contraseña : EditText
    private lateinit var nombre : EditText
    private lateinit var apellido : EditText
    private lateinit var crearCuenta : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loging)

        auth = Firebase.auth
        database = FirebaseDatabase.getInstance()
        usuariosRef = database.getReference("usuarios")

        correo = findViewById(R.id.Correo)
        contraseña = findViewById(R.id.ContraseñaLog)
        nombre = findViewById(R.id.Nombre)
        apellido = findViewById(R.id.Apellido)
        crearCuenta = findViewById(R.id.BotonCrearCuent)

        crearCuenta.setOnClickListener {
            if (correo.text.isNotEmpty() && contraseña.text.isNotEmpty() && nombre.text.isNotEmpty() && apellido.text.isNotEmpty()){
                auth.createUserWithEmailAndPassword(
                    correo.text.toString(),
                    contraseña.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        datosUsuario(
                            correo.text.toString(),
                            nombre.text.toString(),
                            apellido.text.toString()
                        )
                        val registrado = Intent(this, MainActivity::class.java)
                        startActivity(registrado)
                    }else{
                        showAlert("Error registrando el usuario")
                }

                }
            }
        }

    }

    private fun showAlert(mensaje : String){
        //Log.d(TAG, "Error creando nuevo usuario")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar",null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun datosUsuario (correo : String, nombre : String, apellido : String){
        val usuarioActual : FirebaseUser? = auth.currentUser
        if (usuarioActual !=null) {
            // insertamos los datos del usuario actual en nuestra Base de Datos
            val user = Usuario (correo, nombre, apellido)
            usuariosRef.child(usuarioActual.uid).setValue(user)
        } else {

        }

    }
}


