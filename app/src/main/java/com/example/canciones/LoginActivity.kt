package com.example.canciones

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etUser = findViewById<EditText>(R.id.etUsuario)
        val etPass = findViewById<EditText>(R.id.etPassword)
        val btnEntrar = findViewById<Button>(R.id.btnLogin)
        val btnRegistro = findViewById<Button>(R.id.btnRegistro)

        btnEntrar.setOnClickListener {
            val user = etUser.text.toString()
            val pass = etPass.text.toString()

            // Comprobación
            if (user == "admin" && pass == "1234") {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_NAME", user)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegistro.setOnClickListener {
            Toast.makeText(this, "Registro no disponible", Toast.LENGTH_SHORT).show()
        }
    }
}