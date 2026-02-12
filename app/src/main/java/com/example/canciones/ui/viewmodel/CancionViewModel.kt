package com.example.canciones.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.canciones.domain.model.Cancion
import com.example.canciones.domain.usecase.AddCancionesUseCase
import com.example.canciones.domain.usecase.DeleteCancionUseCase
import com.example.canciones.domain.usecase.GetCancionesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CancionViewModel @Inject constructor(
    private val getCancionesUseCase: GetCancionesUseCase,
    private val addCancionesUseCase: AddCancionesUseCase,
    private val deleteCancionUseCase: DeleteCancionUseCase
) : ViewModel() {

    private val _lista = MutableLiveData<List<Cancion>>()
    val lista: LiveData<List<Cancion>> = _lista

    fun cargarCanciones() {
        viewModelScope.launch {
            val resultado = getCancionesUseCase()
            _lista.postValue(resultado)
        }
    }

    fun agregarCancion(cancion: Cancion) {
        viewModelScope.launch {
            addCancionesUseCase(cancion)
            cargarCanciones()
        }
    }

    fun borrarCancion(cancion: Cancion) {
        viewModelScope.launch {
            deleteCancionUseCase(cancion)
            cargarCanciones()
        }
    }

    fun editarCancion(cancion: Cancion) {
        agregarCancion(cancion)
    }
}