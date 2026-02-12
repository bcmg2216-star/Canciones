package com.example.canciones

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.canciones.adapter.CancionAdapter
import com.example.canciones.domain.model.Cancion
import com.example.canciones.ui.viewmodel.CancionViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CancionesFragment : Fragment(R.layout.fragment_canciones), FormCancionFragment.OnCancionSavedListener {

    private val viewModel: CancionViewModel by viewModels()
    private lateinit var adapter: CancionAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = view.findViewById<RecyclerView>(R.id.rvCanciones)
        val fab = view.findViewById<FloatingActionButton>(R.id.fabAdd)

        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        // Inicializamos el adapter con una lista vacía
        adapter = CancionAdapter(
            lista = mutableListOf(),
            onDelete = { pos ->
                // Obtenemos la canción directamente del adapter para borrarla
                val cancion = adapter.lista[pos]
                viewModel.borrarCancion(cancion)
                Toast.makeText(context, "Borrada", Toast.LENGTH_SHORT).show()
            },
            onEdit = { pos ->
                val cancion = adapter.lista[pos]
                val dialogo = FormCancionFragment.newInstance(cancion, pos)
                dialogo.show(childFragmentManager, "edit")
            },
            onItemClick = { pos ->
                val action = CancionesFragmentDirections.actionCancionesToDetalle(pos)
                findNavController().navigate(action)
            }
        )

        recycler.adapter = adapter

        viewModel.lista.observe(viewLifecycleOwner) { listaCanciones ->
            adapter.updateList(listaCanciones.toMutableList())
        }

        // Pedimos cargar los datos al iniciar
        viewModel.cargarCanciones()

        fab.setOnClickListener {
            val dialogo = FormCancionFragment.newInstance(null, null)
            dialogo.show(childFragmentManager, "add")
        }
    }

    override fun onCancionSaved(cancion: Cancion, position: Int?) {
        // Usamos el ViewModel para guardar o editar
        if (position != null) {
            // Al tener el mismo ID (porque viene de la BBDD), Room lo actualiza
            viewModel.agregarCancion(cancion)
            Toast.makeText(context, "Modificado", Toast.LENGTH_SHORT).show()
        } else {
            viewModel.agregarCancion(cancion)
            Toast.makeText(context, "Guardado", Toast.LENGTH_SHORT).show()
        }
    }
}