package com.example.canciones.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

// Aquí listamos las tablas y la versión de la BBDD
@Database(entities = [CancionEntity::class], version = 1)
abstract class CancionesDatabase : RoomDatabase() {

    // Método abstracto para que Room nos fabrique el DAO
    abstract fun cancionDao(): CancionDao
}