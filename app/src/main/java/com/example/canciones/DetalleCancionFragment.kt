package com.example.canciones

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.canciones.controler.ControllerCanciones

class DetalleCancionFragment : Fragment(R.layout.fragment_detalle) {

    private val args: DetalleCancionFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val posicion = args.posicion
        val controller = ControllerCanciones()
        controller.loadData()

        if (posicion < controller.lista.size) {
            val cancion = controller.lista[posicion]

            val img: ImageView = view.findViewById(R.id.imgDetalle)
            val tvTitulo: TextView = view.findViewById(R.id.tvTituloDetalle)
            val tvAutor: TextView = view.findViewById(R.id.tvAutorDetalle)
            val tvAlbum: TextView = view.findViewById(R.id.tvAlbumDetalle)
            val tvDuracion: TextView = view.findViewById(R.id.tvDuracionDetalle)

            Glide.with(this).load(cancion.imagen).into(img)
            tvTitulo.text = cancion.titulo
            tvAutor.text = cancion.autor
            tvAlbum.text = "Álbum: ${cancion.album}"
            tvDuracion.text = "Duración: ${cancion.duracion}"
        }
    }
}