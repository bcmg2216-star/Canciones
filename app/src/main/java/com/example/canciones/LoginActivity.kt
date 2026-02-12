package com.example.canciones

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPref = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE)
        val isLogged = sharedPref.getBoolean("is_logged", false)

        if (isLogged) {
            // Si ya estaba logueado, vamos directo al Main sin pedir contraseña
            val user = sharedPref.getString("user_name", "Usuario")
            irAMain(user)
            return // Cortamos aquí para que no siga cargando el Login
        }

        setContentView(R.layout.activity_login)

        val etUser = findViewById<EditText>(R.id.etUsuario)
        val etPass = findViewById<EditText>(R.id.etPassword)
        val btnEntrar = findViewById<Button>(R.id.btnLogin)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnEntrar.setOnClickListener {
            val user = etUser.text.toString()
            val pass = etPass.text.toString()

            if (user.isNotEmpty() && pass == "1234") {

                val editor = sharedPref.edit()
                editor.putBoolean("is_logged", true)
                editor.putString("user_name", user)
                editor.apply()

                irAMain(user)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegistro.setOnClickListener {
            Toast.makeText(this, "Registro no disponible", Toast.LENGTH_SHORT).show()
        }
    }

    private fun irAMain(user: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("USER_NAME", user)
        startActivity(intent)
        finish()
    }
}