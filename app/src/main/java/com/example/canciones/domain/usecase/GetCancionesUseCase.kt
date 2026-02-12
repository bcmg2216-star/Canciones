package com.example.canciones.domain.usecase

import com.example.canciones.domain.model.Cancion
import com.example.canciones.domain.repository.CancionRepository
import javax.inject.Inject

class GetCancionesUseCase @Inject constructor(
    private val repository: CancionRepository
) {
    suspend operator fun invoke(): List<Cancion> {
        return repository.getCanciones()
    }
}