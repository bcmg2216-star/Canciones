package com.example.canciones.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CancionDao {
    @Query("SELECT * FROM tabla_canciones")
    suspend fun getCanciones(): List<CancionEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCancion(cancion: CancionEntity)

    @Delete
    suspend fun deleteCancion(cancion: CancionEntity)

    @Query("DELETE FROM tabla_canciones")
    suspend fun deleteAll()
}