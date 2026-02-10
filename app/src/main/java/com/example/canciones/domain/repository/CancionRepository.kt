package com.example.canciones.domain.repository

import com.example.canciones.domain.model.Cancion

interface CancionRepository {
    suspend fun getCanciones(): List<Cancion>
    suspend fun insertCancion(cancion: Cancion)
    suspend fun deleteCancion(cancion: Cancion)
}