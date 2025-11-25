package com.example.canciones.models

// Modelo de datos de una canción
data class Cancion (
    var titulo: String,
    var autor: String,
    var album: String,
    var duracion: String,
    var imagen: Int
    )