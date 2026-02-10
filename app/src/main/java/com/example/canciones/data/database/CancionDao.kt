package com.example.canciones.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CancionDao {
    // Obtener todas las canciones
    @Query("SELECT * FROM tabla_canciones")
    suspend fun getCanciones(): List<CancionEntity>

    // Insertar (o actualizar si ya existe)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCancion(cancion: CancionEntity)

    // Borrar una canción
    @Delete
    suspend fun deleteCancion(cancion: CancionEntity)

    // Borrar todo (opcional, pero útil)
    @Query("DELETE FROM tabla_canciones")
    suspend fun deleteAll()
}