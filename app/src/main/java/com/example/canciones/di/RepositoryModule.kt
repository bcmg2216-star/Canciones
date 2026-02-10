package com.example.canciones.di

import com.example.canciones.data.repository.CancionRepositoryImpl
import com.example.canciones.domain.repository.CancionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCancionRepository(
        impl: CancionRepositoryImpl
    ): CancionRepository
}