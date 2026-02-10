package com.example.canciones.controler

import com.example.canciones.dao.DaoCanciones
import com.example.canciones.domain.model.Cancion

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

    // Añado una canción nueva
    fun addCancion(cancion: Cancion){
        lista.add(cancion)
    }

    // Edito una canción
    fun editCancion(pos: Int, cancionEdit: Cancion){
        lista[pos] = cancionEdit
    }
}
