package com.example.canciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.canciones.adapter.CancionAdapter
import com.example.canciones.controler.ControllerCanciones
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val controller = ControllerCanciones()
    private lateinit var adapter: CancionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller.loadData()

        val recycler = findViewById<RecyclerView>(R.id.rvCanciones)
        val fab = findViewById<FloatingActionButton>(R.id.fabAdd)

        recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        adapter = CancionAdapter(controller.lista) { pos ->
            val titulo = controller.lista[pos].titulo
            controller.deleteCancion(titulo)
            adapter.updateList(controller.lista)
            Toast.makeText(this, "Canción borrada", Toast.LENGTH_SHORT).show()
        }

        recycler.adapter = adapter

        // Botón flotante
        fab.setOnClickListener {
            Toast.makeText(this, "Alta de canción (próximamente)", Toast.LENGTH_SHORT).show()
        }
    }
}
