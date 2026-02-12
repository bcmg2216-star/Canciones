package com.example.canciones.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.canciones.domain.model.Cancion

@Entity(tableName = "tabla_canciones")
data class CancionEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "titulo") val titulo: String,
    @ColumnInfo(name = "autor") val autor: String,
    @ColumnInfo(name = "album") val album: String,
    @ColumnInfo(name = "duracion") val duracion: String,
    @ColumnInfo(name = "imagen") val imagen: Int
)

fun CancionEntity.toDomain() = Cancion(id, titulo, autor, album, duracion, imagen)
fun Cancion.toEntity() = CancionEntity(id, titulo, autor, album, duracion, imagen)