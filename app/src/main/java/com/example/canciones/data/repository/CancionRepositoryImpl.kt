package com.example.canciones.data.repository

import com.example.canciones.data.database.CancionDao
import com.example.canciones.data.database.toDomain
import com.example.canciones.data.database.toEntity
import com.example.canciones.domain.model.Cancion
import com.example.canciones.domain.repository.CancionRepository
import javax.inject.Inject

class CancionRepositoryImpl @Inject constructor(
    private val dao: CancionDao
) : CancionRepository {

    override suspend fun getCanciones(): List<Cancion> {
        // Obtenemos Entities de la BBDD y las convertimos a Domain
        return dao.getCanciones().map { it.toDomain() }
    }

    override suspend fun insertCancion(cancion: Cancion) {
        // Convertimos Domain a Entity y guardamos
        dao.insertCancion(cancion.toEntity())
    }

    override suspend fun deleteCancion(cancion: Cancion) {
        dao.deleteCancion(cancion.toEntity())
    }
}