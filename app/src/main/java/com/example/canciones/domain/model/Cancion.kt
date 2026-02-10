package com.example.canciones.domain.model

// Modelo de datos de una canción
data class Cancion (
    val id: Int = 0,
    var titulo: String,
    var autor: String,
    var album: String,
    var duracion: String,
    var imagen: Int
    )