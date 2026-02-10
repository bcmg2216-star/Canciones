package com.example.canciones.di

import android.content.Context
import androidx.room.Room
import com.example.canciones.data.database.CancionDao
import com.example.canciones.data.database.CancionesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DATABASE_NAME = "canciones_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): CancionesDatabase {
        return Room.databaseBuilder(
            context,
            CancionesDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideCancionDao(db: CancionesDatabase): CancionDao {
        return db.cancionDao()
    }
}