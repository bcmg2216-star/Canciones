package com.example.canciones

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.canciones.ui.viewmodel.CancionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetalleCancionFragment : Fragment(R.layout.fragment_detalle) {

    private val args: DetalleCancionFragmentArgs by navArgs()
    // Inyectamos el ViewModel
    private val viewModel: CancionViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val posicion = args.posicion

        // Referencias a las vistas
        val img: ImageView = view.findViewById(R.id.imgDetalle)
        val tvTitulo: TextView = view.findViewById(R.id.tvTituloDetalle)
        val tvAutor: TextView = view.findViewById(R.id.tvAutorDetalle)
        val tvAlbum: TextView = view.findViewById(R.id.tvAlbumDetalle)
        val tvDuracion: TextView = view.findViewById(R.id.tvDuracionDetalle)

        // Observamos la lista del ViewModel
        viewModel.lista.observe(viewLifecycleOwner) { canciones ->
            if (posicion < canciones.size) {
                val cancion = canciones[posicion]

                Glide.with(this).load(cancion.imagen).into(img)
                tvTitulo.text = cancion.titulo
                tvAutor.text = cancion.autor
                tvAlbum.text = "Álbum: ${cancion.album}"
                tvDuracion.text = "Duración: ${cancion.duracion}"
            } else {
                Toast.makeText(context, "No se encontró la canción", Toast.LENGTH_SHORT).show()
            }
        }

        // Cargamos los datos
        viewModel.cargarCanciones()
    }
}