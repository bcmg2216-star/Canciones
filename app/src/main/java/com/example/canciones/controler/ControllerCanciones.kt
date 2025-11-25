package com.example.canciones.controler

import com.example.canciones.dao.DaoCanciones
import com.example.canciones.models.Cancion

class ControllerCanciones {
    lateinit var lista: MutableList<Cancion>

    fun loadData() {
        // Carga las canciones desde el DAO
        lista = DaoCanciones.getCanciones()
    }

    fun deleteCancion(titulo: String) {
        // Borra la canción
        lista.removeIf { it.titulo == titulo }
    }
}
