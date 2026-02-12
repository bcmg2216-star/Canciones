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
        return dao.getCanciones().map { it.toDomain() }
    }

    override suspend fun insertCancion(cancion: Cancion) {
        dao.insertCancion(cancion.toEntity())
    }

    override suspend fun deleteCancion(cancion: Cancion) {
        dao.deleteCancion(cancion.toEntity())
    }
}