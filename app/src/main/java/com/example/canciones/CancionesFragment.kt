package com.example.canciones

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canciones.adapter.CancionAdapter
import com.example.canciones.controler.ControllerCanciones
import com.example.canciones.domain.model.Cancion
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CancionesFragment : Fragment(R.layout.fragment_canciones), FormCancionFragment.OnCancionSavedListener {

    private val controller = ControllerCanciones()
    private lateinit var adapter: CancionAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller.loadData()

        val recycler = view.findViewById<RecyclerView>(R.id.rvCanciones)
        val fab = view.findViewById<FloatingActionButton>(R.id.fabAdd)

        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        adapter = CancionAdapter(
            lista = controller.lista,
            onDelete = { pos ->
                val titulo = controller.lista[pos].titulo
                controller.deleteCancion(titulo)
                adapter.updateList(controller.lista)
                Toast.makeText(context, "Borrado", Toast.LENGTH_SHORT).show()
            },
            onEdit = { pos ->
                val cancion = controller.lista[pos]
                val dialogo = FormCancionFragment.newInstance(cancion, pos)
                dialogo.show(childFragmentManager, "edit")
            },
            onItemClick = { pos ->
                val action = CancionesFragmentDirections.actionCancionesToDetalle(pos)
                findNavController().navigate(action)
            }
        )

        recycler.adapter = adapter

        fab.setOnClickListener {
            val dialogo = FormCancionFragment.newInstance(null, null)
            dialogo.show(childFragmentManager, "add")
        }
    }

    override fun onCancionSaved(cancion: Cancion, position: Int?) {
        if (position != null){
            controller.editCancion(position, cancion)
            Toast.makeText(context, "Modificado", Toast.LENGTH_SHORT).show()
        } else {
            controller.addCancion(cancion)
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
        }
        adapter.updateList(controller.lista)
    }
}