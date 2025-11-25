package com.example.canciones.dao

import com.example.canciones.R
import com.example.canciones.models.Cancion

object DaoCanciones {
    // Lista de las canciones elegidas
    fun getCanciones(): MutableList<Cancion>{
        return mutableListOf(
            Cancion("La promesa", "Melendi", "Single", "3:15", R.drawable.la_promesa),
            Cancion("Chulo", "Bad Gyal", "Single", "2:45", R.drawable.chulo),
            Cancion("Paseo", "Estopa", "Album", "3:05", R.drawable.paseo),
            Cancion("Cuando zarpa el amor", "Camela", "Album", "4:00", R.drawable.cuando_zarpa),
            Cancion("Bailando por ahí", "Juan Magán", "Single", "3:30", R.drawable.bailando_por_ahi)
        )
    }
}