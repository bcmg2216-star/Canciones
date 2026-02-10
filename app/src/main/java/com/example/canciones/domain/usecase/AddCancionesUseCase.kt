package com.example.canciones.domain.usecase

import com.example.canciones.domain.model.Cancion
import com.example.canciones.domain.repository.CancionRepository
import javax.inject.Inject

class AddCancionUseCase @Inject constructor(
    private val repository: CancionRepository
) {
    suspend operator fun invoke(cancion: Cancion) {
        repository.insertCancion(cancion)
    }
}