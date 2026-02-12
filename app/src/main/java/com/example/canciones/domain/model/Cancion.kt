package com.example.canciones.domain.model

data class Cancion(
    val id: Int = 0,
    val titulo: String,
    val autor: String,
    val album: String,
    val duracion: String,
    val imagen: Int
)